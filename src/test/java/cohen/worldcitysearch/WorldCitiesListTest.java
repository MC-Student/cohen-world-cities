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

        WorldCity actual = new WorldCity("Park Forest", 41.4817, -87.6867);

        WorldCity result = cities.getClosestCity(41.8375, -87.686);

        assertEquals(result.city(), actual.city());
        assertEquals(result.lat(), actual.lat());
        assertEquals(result.lon(), actual.lon());
    }
}