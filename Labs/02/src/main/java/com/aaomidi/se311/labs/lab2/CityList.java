package com.aaomidi.se311.labs.lab2;

import java.util.LinkedHashMap;

/**
 * SE 311 Lab 2
 * <p>
 * Each object of this class represents a list of cities.
 * </p>
 *
 * @version 1.0
 */
public class CityList {
    public String country;
    private LinkedHashMap<String, City> cityMap;

    public CityList() {
        this.country = "";
        this.cityMap = new LinkedHashMap<>();
    }

    public CityList(String country) {
        this.country = country;
        this.cityMap = new LinkedHashMap<>();
    }

    /**
     * @return cities
     */
    public LinkedHashMap<String, City> getCityInfo() {
        return cityMap;
    }

    /**
     * @param city to add to the cityMap
     */
    public void addToCityList(City city) {
        this.cityMap.put(city.name, city);
    }

    /**
     * Clears the collection of cities.
     */
    public void clearCityList() {
        this.cityMap.clear();
        //this.cityMap = new LinkedHashMap<>();
    }
}