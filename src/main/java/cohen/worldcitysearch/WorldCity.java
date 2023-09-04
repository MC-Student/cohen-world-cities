package cohen.worldcitysearch;

public class WorldCity
{
    private String cityName;
    private final double lat;
    private final double lon;

    public WorldCity(double lat, double lon)
    {
        cityName = null;
        this.lat = lat;
        this.lon = lon;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
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
