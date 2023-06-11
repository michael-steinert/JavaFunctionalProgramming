package streams.examples;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class JoiningStrings {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = List.of("Michael", "Bruno", "Bella", "Marie");
    StringBuilder joinedStrings = new StringBuilder();
    for (String name : names) {
      joinedStrings.append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).append(",");
    }
    System.out.println("Joined Uppercase Names: %s".formatted(joinedStrings.substring(0, joinedStrings.length() - 1)));
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = List.of("Michael", "Bruno", "Bella", "Marie");
    String joinedStrings = names.stream().map(name -> {
      return name.substring(0, 1).toUpperCase() + name.substring(1);
    }).collect(Collectors.joining(","));
    System.out.println(joinedStrings);
  }
}
