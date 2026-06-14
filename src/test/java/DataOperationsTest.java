package data_operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataOperationsTest {

    private List<Person> people;

    @BeforeEach
    void setUp() {
        people = new ArrayList<>();
        people.add(new Person(1, "Mateusz", 28, "Gdańsk"));
        people.add(new Person(2, "Anna", 22, "Warszawa"));
        people.add(new Person(3, "Kamil", 35, "Gdańsk"));
        people.add(new Person(4, "Ola", 19, "Kraków"));
    }

    // -----------------------------
    // findById
    // -----------------------------
    @Test
    void testFindById_Found() {
        Person result = DataOperations.findById(people, 3);
        assertNotNull(result);
        assertEquals("Kamil", result.getName());
    }

    @Test
    void testFindById_NotFound() {
        Person result = DataOperations.findById(people, 99);
        assertNull(result);
    }

    // -----------------------------
    // filterByCity
    // -----------------------------
    @Test
    void testFilterByCity_Found() {
        List<Person> result = DataOperations.filterByCity(people, "Gdańsk");

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(p -> p.getName().equals("Mateusz")));
        assertTrue(result.stream().anyMatch(p -> p.getName().equals("Kamil")));
    }

    @Test
    void testFilterByCity_NoResults() {
        List<Person> result = DataOperations.filterByCity(people, "Poznań");
        assertTrue(result.isEmpty());
    }

    // -----------------------------
    // sortByAge
    // -----------------------------
    @Test
    void testSortByAge() {
        List<Person> result = DataOperations.sortByAge(people);

        assertEquals("Ola", result.get(0).getName());      // 19
        assertEquals("Anna", result.get(1).getName());     // 22
        assertEquals("Mateusz", result.get(2).getName());  // 28
        assertEquals("Kamil", result.get(3).getName());    // 35
    }

    // -----------------------------
    // sortByName
    // -----------------------------
    @Test
    void testSortByName() {
        List<Person> result = DataOperations.sortByName(people);

        assertEquals("Anna", result.get(0).getName());
        assertEquals("Kamil", result.get(1).getName());
        assertEquals("Mateusz", result.get(2).getName());
        assertEquals("Ola", result.get(3).getName());
    }
}
