package streams.examples;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import streams.beans.Car;
import streams.beans.Person;
import streams.beans.PersonDto;
import streams.mockdata.MockData;

public class TransformationsMapAndReduce {

  @Test
  void transformationWithMap() throws IOException {
    List<Person> people = MockData.getPeople();
    List<PersonDto> firstPeopleDto = people.stream()
        .filter(person -> person.getAge() > 28)
        .map(person -> {
          return new PersonDto(person.getId(), person.getFirstName(), person.getAge());
        }).collect(Collectors.toList());
    firstPeopleDto.forEach(System.out::println);
    List<PersonDto> secondPeopleDto = people.stream()
        .filter(person -> person.getAge() > 18)
        .map(PersonDto::mapToDto)
        .collect(Collectors.toList());
    secondPeopleDto.forEach(System.out::println);
  }

  @Test
  void mapToDoubleAndFindAverageCarPrice() throws IOException {
    List<Car> cars = MockData.getCars();
    double averageCarPrice = cars.stream().mapToDouble(Car::getPrice).average().orElse(0);
    System.out.println("Average Car Price %f".formatted(averageCarPrice));
  }

  @Test
  public void transformationWithReduce() {
    int[] integers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int firstSum = Arrays.stream(integers).reduce(0, (left, right) -> left + right);
    int secondSum = Arrays.stream(integers).reduce(0, Integer::sum);
    System.out.println("First Sum is %d and second Sum is %d".formatted(firstSum, secondSum));
  }
}
