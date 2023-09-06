package cohen.worldcitysearch.servlet;

import cohen.worldcitysearch.WorldCitiesList;
import cohen.worldcitysearch.WorldCity;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

public class WorldCitySearchServletTest
{

    @Test
    public void doGet() throws IOException
    {
        WorldCitiesList citiesList = mock();
        doReturn(new WorldCity("Chicago", 41.837, -87.686)).when(citiesList).getClosestCity(41.8375, -87.6866);
        Gson gson = new Gson();

        WorldCitySearchServlet servlet = new WorldCitySearchServlet(citiesList, gson);

        HttpServletRequest request = mock();
        doReturn("41.8375").when(request).getParameter("lat");
        doReturn("-87.6866").when(request).getParameter("lon");

        HttpServletResponse response = mock();
        PrintWriter out = mock();
        doReturn(out).when(response).getWriter();

        servlet.doGet(request, response);

        verify(response).setContentType("text/json");
        verify(out).println(anyString());
    }
}