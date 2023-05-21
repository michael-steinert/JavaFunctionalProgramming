package streams.examples;

import streams.beans.Person;
import streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class HowStreamsWork {
  @Test
  public void methodReferenceAndCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
        .collect(Collectors.toList());
    emails.forEach(System.out::println);
  }

  @Test
  public void intermediateAndTerminalOperations() throws Exception {
    System.out.println(
        MockData.getCars()
            .stream()
            .filter(car -> {
              System.out.println("Filter Car " + car);
              return car.getPrice() < 10000;
            })
            .map(car -> {
              System.out.println("Mapping Car " + car);
              return car.getPrice();
            })
            .map(price -> {
              System.out.println("Mapping Price " + price);
              return price + (price * 0.14);
            })
            .collect(Collectors.toList()));
  }
}
