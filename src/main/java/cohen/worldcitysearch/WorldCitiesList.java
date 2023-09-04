package cohen.worldcitysearch;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class WorldCitiesList
{
    private final ArrayList<WorldCity> worldCities;

    public WorldCitiesList() throws IOException
    {
        this.worldCities = new ArrayList<>();

        File csvData = new File("src/main/resources/worldcities.csv");
        CSVParser parser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.RFC4180);

        List<CSVRecord> cities = parser.getRecords();
        int totalRecords = cities.size();

        for (int i = 1; i < totalRecords; i++)
        {
            String city = cities.get(i).get(1);
            String lat = cities.get(i).get(2);
            String lon = cities.get(i).get(3);
            WorldCity worldCity = new WorldCity(Double.parseDouble(lat), Double.parseDouble(lon));
            worldCity.setCityName(city);
            worldCities.add(worldCity);
        }
    }

    public ArrayList<WorldCity> getList()
    {
        return worldCities;
    }

    public WorldCity getClosestCity(WorldCity requestCity)
    {
        //what about kd-trees?? bounding boxes? to make this faster. Although seems like overall
        //no way to get past O(n) time in worst case scenario

        WorldCity closest = worldCities.get(0);
        int searchIndex;

        if (distance(requestCity, closest) == 0)
        {
            closest = worldCities.get(1);
            searchIndex = 2;
        }
        else
        {
            searchIndex = 1;
        }

        for (int i = searchIndex; i < worldCities.size(); i++)
        {
            double currentDist = distance(requestCity, closest);
            WorldCity currentCity = worldCities.get(searchIndex);

            if (distance(requestCity, currentCity) < currentDist)
            {
                closest = currentCity;
            }
        }

        return closest;
    }

    private double distance(WorldCity givenCity, WorldCity compareToCity)
    {
        double latDif = compareToCity.getLat() - givenCity.getLat();
        double lonDif = compareToCity.getLon() - givenCity.getLat();

        return Math.sqrt((latDif * latDif) * (lonDif * lonDif));
    }
}