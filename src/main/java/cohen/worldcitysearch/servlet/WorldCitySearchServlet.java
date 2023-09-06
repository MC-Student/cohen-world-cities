package cohen.worldcitysearch.servlet;

import cohen.worldcitysearch.WorldCitiesList;
import cohen.worldcitysearch.WorldCity;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorldCitySearchServlet extends HttpServlet
{
    private final WorldCitiesList citiesList = new WorldCitiesList();
    private final Gson gson = new Gson();

    public WorldCitySearchServlet() throws IOException
    {
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException
    {
        double lat = Double.parseDouble(req.getParameter("latitude"));
        double lon = Double.parseDouble(req.getParameter("longitude"));

        WorldCity city = citiesList.getClosestCity(lat, lon);

        WorldCitySearchResponse response = new WorldCitySearchResponse(
                city.getCityName(),
                city.getLat(),
                city.getLon()
        );
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(response));
    }
}