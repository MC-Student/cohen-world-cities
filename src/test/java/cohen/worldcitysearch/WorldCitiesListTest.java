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

        WorldCity result = cities.getClosestCity(41.83, -87.6);

        assertEquals("Chicago", result.city());
        assertEquals(41.8375, result.lat());
        assertEquals(-87.6866, result.lon());
    }
}