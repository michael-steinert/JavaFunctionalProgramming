package streams.examples;

import streams.beans.Car;
import streams.beans.Person;
import streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

  @Test
  public void sortingSteamOfElements() throws IOException {
    List<Person> people = MockData.getPeople();
  }

  @Test
  public void sortingSteamOfElementsReverse() throws IOException {
    List<Person> people = MockData.getPeople();
  }

  @Test
  public void sortingSteamOfObjects() throws IOException {
    List<Person> people = MockData.getPeople();
  }

  @Test
  public void topTenMostExpensiveBlueCars() throws IOException {
    List<Car> cars = MockData.getCars();
  }
}
