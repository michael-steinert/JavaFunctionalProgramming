package streams.examples;

import streams.beans.Car;
import streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

  @Test
  public void simpleGrouping() throws Exception {
    List<Car> cars = MockData.getCars();
    Map<String, List<Car>> mapOfCars = cars.stream().collect(Collectors.groupingBy(Car::getMake));
    mapOfCars.forEach((make, carsOfMake) -> {
      System.out.println("Make is %s".formatted(make));
      carsOfMake.forEach(System.out::println);
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    List<String> names = List.of(
        "Michael",
        "Michael",
        "Bruno",
        "Bella",
        "Marie",
        "Marie");
    Map<String, Long> mapOfNames = names.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(mapOfNames);
  }
}