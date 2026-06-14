package data_operations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataOperations {

    // Wyszukiwanie osoby po ID
    public static Person findById(List<Person> people, int id) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Filtrowanie osób po mieście
    public static List<Person> filterByCity(List<Person> people, String city) {
        return people.stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // Sortowanie po wieku rosnąco
    public static List<Person> sortByAge(List<Person> people) {
        return people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }

    // Sortowanie po nazwisku alfabetycznie
    public static List<Person> sortByName(List<Person> people) {
        return people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
    }
}
