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
  }

  @Test
  public void groupingAndCounting() throws Exception {
    List<String> names = List.of(
        "Michael",
        "Michael",
        "Bruno",
        "Bella",
        "Marie",
        "Marie",
        "Vincent");
  }

}