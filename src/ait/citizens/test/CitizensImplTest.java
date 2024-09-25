package ait.citizens.test;

import ait.citizens.dao.Citizens;
import ait.citizens.dao.CitizensImpl;
import ait.citizens.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CitizensImplTest {
    Citizens city;
    Person[] persons;

    @BeforeEach
    void setUp() {
        city = new CitizensImpl();
        persons = new Person[5];
        persons[0] = new Person(205568, "Bruce", "Wayne", LocalDate.of(1956, 5, 25));
        persons[1] = new Person(209008, "Selina", "Kyle", LocalDate.of(1970, 3, 19));
        persons[2] = new Person(208112, "Clark", "Kent", LocalDate.of(1963, 6, 18));
        persons[3] = new Person(207252, "Peter", "Parker", LocalDate.of(1988, 2, 11));
        persons[4] = new Person(206214, "Ben", "Parker", LocalDate.of(1985, 1, 29));
        for (Person person : persons) {
            city.add(person);
        }
    }

    @Test
    void add() {
        assertFalse(city.add(null));
        assertFalse(city.add(persons[2]));
        Person newPerson = new Person(107007, "James", "Bond", LocalDate.of(1920, 11, 11));
        assertTrue(city.add(newPerson));
        assertEquals(6, city.size());
        Person newPerson2 = new Person(107007, "James", "Bond", LocalDate.of(1920, 11, 11));
        assertFalse(city.add(newPerson2));
    }

    @Test
    void remove() {
        assertTrue(city.remove(205568));
        assertEquals(4, city.size());
        assertFalse(city.remove(205568));
        assertFalse(city.remove(222222));
    }

    @Test
    void find() {
        assertEquals(persons[0], city.find(205568));
        assertNull(city.find(222222));
    }

    @Test
    void testFind() {
        Person[] expected = {persons[3], persons[4], persons[1]};
        List<Person> actual = (ArrayList) city.find(35, 55);
        Person[] actualArray = listToArray(actual);
        assertArrayEquals(expected, actualArray);
    }

    @Test
    void testFind1() {
        Person[] expected = {persons[3], persons[4]};
        List<Person> actual = (ArrayList) city.find("Parker");
        Person[] actualArray = listToArray(actual);
        assertArrayEquals(expected, actualArray);
    }

    @Test
    void getAllPersonsSortedById() {
        Person[] expected = {persons[0], persons[4], persons[3], persons[2], persons[1]};
        List<Person> actual = (ArrayList) city.getAllPersonsSortedById();
        Person[] actualArray = listToArray(actual);
        assertArrayEquals(expected, actualArray);
    }

    @Test
    void getAllPersonsSortedByAge() {
        Person[] expected = {persons[3], persons[4], persons[1], persons[2], persons[0]};
        List<Person> actual = (ArrayList) city.getAllPersonsSortedByAge();
        Person[] actualArray = listToArray(actual);
        assertArrayEquals(expected, actualArray);
    }

    @Test
    void getAllPersonsSortedByLastName() {
        Person[] expected = {persons[2], persons[1], persons[3], persons[4], persons[0]};
        List<Person> actual = (ArrayList) city.getAllPersonsSortedByLastName();
        Person[] actualArray = listToArray(actual);
        assertArrayEquals(expected, actualArray);
    }

    @Test
    void size() {
        assertEquals(5,city.size());
    }

    private Person[] listToArray(List<Person> list) {
        int l = list.size();
        Person[] people = new Person[l];
        int i = 0;
        for (Person p : list) {
            people[i] = p;
            i++;
        }
        return people;
    }
}