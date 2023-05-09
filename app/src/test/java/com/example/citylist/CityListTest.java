package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class is for unit testing.
 */
public class CityListTest {
    /**
     * This is for getting added city list.
     * @return cityList;
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * mockCity generate a mock city.
     * @return a new instance of city class.
     */
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * This method is for unit test if city is added successfully or not.
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * if there any exception when adding city is test by this method.
     */

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    /**
     * This test is for rendering test of all city.
     */
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    /**
     *  This test is for sorting of city.
     */
    @Test
    public void testSort() {
        CityList cityList = new CityList();
        City city = new City("KUET", "Khulna");
        cityList.add(city);
        City city1 = new City("Narsindi", "Dhaka");
        cityList.add(city1);

        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));

    }

    /**
     * This test is for count all city.
     */
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("Narsingdi", "Dhaka");
        City city1 = new City("Gazipur", "Dhaka");

        cityList.add(city);
        cityList.add(city1);
        assertEquals(2, cityList.count());

        cityList.delete(city);
        assertEquals(1, cityList.count());

    }

    /**
     * This test is for successful delete of added city.
     */
    @Test
    public void testDelete() {
        CityList cityList = new CityList();
        City city = new City("Narsingdi", "Dhaka");
        City city1 = new City("Gazipur", "Dhaka");

        cityList.add(city);
        cityList.add(city1);

        cityList.delete(city);

        assertFalse(cityList.getCities(0).contains(city));
    }

    /**
     * if there any exception is throw when deleting is tested here.
     */
    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = new City("Jessore", "Khulna");
        City city1 = new City("Chandpur", "Noakhali");

        cityList.add(city);
        cityList.add(city1);

        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city));
    }


}
