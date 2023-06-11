package streams.examples;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import streams.beans.Car;
import streams.beans.Person;
import streams.mockdata.MockData;

public class Sorting {

  @Test
  public void sortingSteamOfElements() throws IOException {
    List<Person> people = MockData.getPeople();
    List<String> sortedFirstName = people.stream().map(Person::getFirstName).sorted()
        .collect(Collectors.toList());
    sortedFirstName.forEach(System.out::println);
  }

  @Test
  public void sortingSteamOfElementsReverse() throws IOException {
    List<Person> people = MockData.getPeople();
    List<String> sortedFirstName = people.stream().map(Person::getFirstName).sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    sortedFirstName.forEach(System.out::println);
  }

  @Test
  public void sortingSteamOfObjects() throws IOException {
    List<Person> people = MockData.getPeople();
    List<Person> sortedPeople = people.stream().sorted(Comparator.comparing(Person::getFirstName))
        .collect(Collectors.toList());
    sortedPeople.forEach(System.out::println);
  }

  @Test
  public void topTenMostExpensiveBlueCars() throws IOException {
    List<Car> cars = MockData.getCars();
    List<Car> topTenMostExpensiveBlueCars = cars.stream()
        .filter(car -> car.getColor().equalsIgnoreCase("blue"))
        .sorted(Comparator.comparing(Car::getPrice))
        .limit(10)
        .collect(Collectors.toList());
    topTenMostExpensiveBlueCars.forEach(System.out::println);
  }
}
