package streams.examples;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MinMax {

  @Test
  public void min() {
    List<Integer> numbers = List.of(2, 1, 3, 100, 42, 21, 99);
    System.out.println(numbers.stream().min(Comparator.naturalOrder()).get());
  }

  @Test
  public void max() {
    List<Integer> numbers = List.of(2, 1, 3, 100, 42, 21, 99);
    System.out.println(numbers.stream().max(Integer::compareTo).get());
  }
}
