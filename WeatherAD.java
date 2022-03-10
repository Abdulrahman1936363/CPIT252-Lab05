package edu.kau.fcit.cpit252;

import edu.kau.fcit.cpit252.geoLocation.*;
import edu.kau.fcit.cpit252.weatherDB.*;

public class WeatherAD implements WeatherGeo {

    String cityName;
    static WeatherAD ad = null;

    private WeatherAD() {

    }

    // in case the user entered lat and long to get weather info
    public String getWeatherInfo(double latitude, double longitude) {
        // if the user enterd wrong lat and long values
        this.cityName = new GeoLocation().search(latitude, longitude);
        if (cityName == null) {
            return "City Not Found";
        }
        WeatherCity wdb = new WeatherDBI();
        return wdb.getWeatherInfo(cityName);
    }

    // in case the user entered the city name
    public String getWeatherInfo(String cityName) {
        WeatherCity wdb = new WeatherDBI();
        return wdb.getWeatherInfo(cityName);
    }

    public String getCityName(double latitude, double longitude) {
        this.cityName = new GeoLocation().search(latitude, longitude);

        return cityName;
    }

    //**Singlton**
    public static WeatherAD getAdapterInstance() {
        if (ad == null) {
            ad = new WeatherAD();
            return ad;
        }
        return ad;
    }

}
