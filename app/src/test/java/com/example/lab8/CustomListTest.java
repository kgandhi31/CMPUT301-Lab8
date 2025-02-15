package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * add a new city to the list
     * check if the list has the added city
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * add a new city to the list
     * delete the city
     * check if the city exists in the list
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);

        list.delete(city);
        assertFalse(list.hasCity(city));
    }

    /**
     * add a new city to the list
     * delete the city
     * check if deleting the same city object throws an exception
     */
    @Test
    public void deleteCityExceptionTest() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);

        list.delete(city);
        assertThrows(IllegalArgumentException.class, ()->list.delete(city));
    }

    /**
     * add two new cities to the list
     * check if list contains two city objects
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        City city1 = new City("Edmonton", "AB");
        list.addCity(city1);
        City city2 = new City("Winnipeg", "MB");
        list.addCity(city2);

        assertEquals(2, list.countCities());
    }
}
