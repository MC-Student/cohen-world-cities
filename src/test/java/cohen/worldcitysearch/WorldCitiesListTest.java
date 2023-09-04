package cohen.worldcitysearch;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorldCitiesListTest
{

    @Test
    public void getList() throws IOException
    {
        WorldCitiesList cities = new WorldCitiesList();
        ArrayList<WorldCity> cityList = cities.getList();
        assertEquals(cityList.size(), 44691);
    }

    @Test
    public void getClosestCity() throws IOException
    {
        WorldCitiesList cities = new WorldCitiesList();

        WorldCity actual = new WorldCity("Lincolnwood", 42.0054, -87.733);

        WorldCity request = new WorldCity("", 41.8375, -87.6866);

        WorldCity result = cities.getClosestCity(request);

        assertEquals(result.getCityName(), actual.getCityName());
        assertEquals(result.getLat(), actual.getLat());
        assertEquals(result.getLon(), actual.getLon());
    }
}