package streams.examples;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import streams.beans.Car;
import streams.mockdata.MockData;

public class Filtering {

  @Test
  public void filter() throws Exception {
    List<Car> cars = MockData.getCars();
    List<Car> redCars = cars.stream().filter(car -> car.getColor().equals("red")).collect(Collectors.toList());
    redCars.stream().forEach(System.out::println);
  }

  @Test
  public void dropWhile() throws Exception {
    System.out.println("using filter()");
    Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
    System.out.println();
    System.out.println("using dropWhile()");
  }

  @Test
  public void takeWhile() throws Exception {
    System.out.println("using filter()");
    Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
    System.out.println();
    System.out.println("using takeWhile()");
  }

  @Test
  public void findFirst() throws Exception {
    int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    OptionalInt OptionalFirstNumber = Arrays.stream(numbers).filter(n -> n == 4).findFirst();
    System.out.println(OptionalFirstNumber.getAsInt());
  }

  @Test
  public void findAny() throws Exception {
    int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10 };
    OptionalInt OptionalAnyNumber = Arrays.stream(numbers).filter(n -> n == 4).findAny();
    System.out.println(OptionalAnyNumber.getAsInt());
  }

  @Test
  public void allMatch() throws Exception {
    int[] evenNumbers = { 2, 4, 6, 8, 10 };
    boolean isAllMatching = Arrays.stream(evenNumbers).allMatch(n -> n % 2 == 0);
    System.out.println(isAllMatching);
  }

  @Test
  public void anyMatch() throws Exception {
    int[] evenAndOddNumbers = { 2, 4, 6, 8, 10, 11 };
    boolean isAllMatching = Arrays.stream(evenAndOddNumbers).anyMatch(n -> n % 2 == 0);
    System.out.println(isAllMatching);
  }
}
