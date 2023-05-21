package streams.examples;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import streams.beans.Person;
import streams.mockdata.MockData;

public class IntStreams {

  @Test
  public void range() throws Exception {
    for (int i = 0; i <= 10; i++) {
      System.out.println(i);
    }
    IntStream.rangeClosed(0, 10).forEach(System.out::println);
  }

  // Loop through People using IntStream
  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
    IntStream.range(0, people.size()).limit(10).forEach(index -> {
      System.out.println(people.get(index));
    });
  }

  @Test
  public void intStreamIterate() {
    IntStream.iterate(0, value -> value + 1).limit(42).forEach(System.out::println);
  }
}
