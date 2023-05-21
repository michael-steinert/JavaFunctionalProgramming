package streams.examples;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class DistinctAndSets {

  @Test
  public void distinct() throws Exception {
    List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9);
    List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
    assertThat(distinctNumbers).hasSize(9);
    distinctNumbers.stream().forEach(System.out::println);
  }

  @Test
  public void distinctWithSet() throws Exception {
    List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9);
    Set<Integer> numbersAsSet = numbers.stream().collect(Collectors.toSet());
    assertThat(numbersAsSet).hasSize(9);
    numbersAsSet.stream().forEach(System.out::println);
  }
}
