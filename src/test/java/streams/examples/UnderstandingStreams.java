package streams.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import streams.beans.Person;
import streams.mockdata.MockData;

public class UnderstandingStreams {

  @Test
  void collect() throws IOException {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        // .collect(
        // () -> new ArrayList<String>(),
        // (list, element) -> list.add(element),
        // (firstList, secondList) -> firstList.addAll(secondList));
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
              System.out.println("Filter Car: %s".formatted(car));
              return car.getPrice() < 10000;
            })
            .map(car -> {
              System.out.println("Mapping Car ".formatted(car));
              return car.getPrice();
            })
            .map(price -> {
              System.out.println("Mapping Price " + price);
              return price + (price * 0.1);
            })
            // Streams are only processed when there is a Terminal Operator like collect()
            // or
            // sum(), therefore Streams are lazy
            .collect(Collectors.toList()));
  }
}
