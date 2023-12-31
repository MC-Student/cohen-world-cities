package cohen.worldcitysearch.servlet;

import cohen.worldcitysearch.WorldCitiesList;
import cohen.worldcitysearch.WorldCity;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorldCitySearchServlet extends HttpServlet
{
    private final WorldCitiesList citiesList;
    private final Gson gson;

    public WorldCitySearchServlet() throws IOException
    {
        this(new WorldCitiesList(), new Gson());
    }
    public WorldCitySearchServlet(WorldCitiesList citiesList, Gson gson) throws IOException
    {
        this.citiesList = citiesList;
        this.gson = gson;
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws IOException
    {
        double lat = Double.parseDouble(req.getParameter("lat"));
        double lon = Double.parseDouble(req.getParameter("lon"));

        WorldCity city = citiesList.getClosestCity(lat, lon);

        WorldCitySearchResponse response = new WorldCitySearchResponse(
                city.city(),
                city.lat(),
                city.lon()
        );
        resp.setContentType("text/json");
        resp.getWriter().println(gson.toJson(response));
    }
}