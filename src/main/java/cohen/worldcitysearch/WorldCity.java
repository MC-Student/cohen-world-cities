package cohen.worldcitysearch;

public class WorldCity
{
    private final String cityName;
    private final double lat;
    private final double lon;

    public WorldCity(String city, double lat, double lon)
    {
        this.cityName = city;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCityName()
    {
        return cityName;
    }

    public double getLat()
    {
        return lat;
    }

    public double getLon()
    {
        return lon;
    }
}
