package streams.examples;

import streams.beans.Person;
import streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreams {

  @Test
  public void range() throws Exception {
  }

  // Loop through People using IntStream
  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();
  }

  @Test
  public void intStreamIterate() {
  }
}
