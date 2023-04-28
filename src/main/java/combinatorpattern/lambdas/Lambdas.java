package combinatorpattern.lambdas;

import java.util.function.Function;

public class Lambdas {
  public static void main(String[] args) {
    Function<String, String> upperCaseName = (name) -> {
      if (name.isBlank()) {
        throw new IllegalStateException("Name is blank");
      }
      return name.toUpperCase();
    };

    String upperCasedName = upperCaseName.apply("Michael");

    System.out.println(upperCasedName);
  }
}
