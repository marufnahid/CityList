package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    public List<City> getCities(int parameter) {
        List<City> cityList = cities;
        if(parameter == 0)
        {
            Collections.sort(cityList);
        }
        else
        {
            cityList.sort(Comparator.comparing(City::getProvinceName));
        }
        return cityList;
    }


    public void delete(City city){
        if (!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    public int count(){
        List<City> cityList = getCities();
        return cityList.size();
    }
}
