package streams.examples;

import streams.beans.Person;
import streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnderstandingStreams {

  @Test
  void collect() throws IOException {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(
            ArrayList::new,
            ArrayList::add,
            ArrayList::addAll);
    emails.forEach(System.out::println);
  }

  @Test
  public void lazy() throws Exception {
    System.out.println(
        MockData.getCars()
            .stream()
            .filter(car -> {
              System.out.println("Filter Car " + car);
              return car.price() < 10000;
            })
            .map(car -> {
              System.out.println("Mapping Car " + car);
              return car.price();
            })
            .map(price -> {
              System.out.println("Mapping Price " + price);
              return price + (price * 0.14);
            })
            .collect(Collectors.toList()));
  }
}
