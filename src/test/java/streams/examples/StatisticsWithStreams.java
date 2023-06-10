package streams.examples;

import streams.beans.Car;
import streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

  @Test
  public void count() throws Exception {
    List<Car> cars = MockData.getCars();
    long carsCount = cars.stream().filter(car -> car.getMake().equalsIgnoreCase("Audi")).count();
    System.out.println("Cars with Make of Audi %d".formatted(carsCount));
  }

  @Test
  public void min() throws Exception {
    List<Car> cars = MockData.getCars();
    double minPrice = cars.stream().mapToDouble(Car::getPrice).min().orElse(0);
    System.out.println("Min Price is %f".formatted(minPrice));
  }

  @Test
  public void max() throws Exception {
    List<Car> cars = MockData.getCars();
    double maxPrice = cars.stream().mapToDouble(Car::getPrice).max().orElse(0);
    System.out.println("Max Price is %f".formatted(maxPrice));
  }

  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double averagePrice = cars.stream().mapToDouble(Car::getPrice).average().orElse(0);
    System.out.println("Average Price is %f".formatted(averagePrice));
  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream().mapToDouble(Car::getPrice).sum();
    System.out.println("Sum of Cars is %s".formatted(BigDecimal.valueOf(sum)));
  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream().mapToDouble(Car::getPrice).summaryStatistics();
    System.out.println(
        "Statistics of Cars is: Count %d, Average: %f and Sum: %s".formatted(
            statistics.getCount(),
            statistics.getAverage(),
            BigDecimal.valueOf(statistics.getSum())));
  }
}