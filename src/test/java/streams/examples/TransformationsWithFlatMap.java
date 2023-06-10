package streams.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransformationsWithFlatMap {

  private static final List<List<String>> arrayListOfNames = List.of(
      List.of("Michael", "Bruno"),
      List.of("Bella", "Marie"),
      List.of("Buddy"));

  @BeforeEach
  void setUp() {
    System.out.println(arrayListOfNames);
  }

  @Test
  public void withoutFlatMap() throws Exception {
    List<String> names = new ArrayList<>();
    // arrayListOfNames.forEach(currentNames -> {
    // names.addAll(currentNames);
    // });
    arrayListOfNames.forEach(names::addAll);
    System.out.println("Names in one List: %s".formatted(names));
  }

  @Test
  public void withFlatMap() throws Exception {
    List<String> names = arrayListOfNames.stream().flatMap(List::stream).collect(Collectors.toList());
    System.out.println("Names in one List: %s".formatted(names));
  }

  @Test
  public void flatMapWithOptionals() {
    List<Optional<String>> optionals = List.of(
        Optional.of("firstOptional"),
        Optional.of("secondOptional"));
    List<String> strings = optionals.stream().flatMap(Optional::stream).collect(Collectors.toList());
    System.out.println("Strings in one List: %s".formatted(strings));
  }
}
