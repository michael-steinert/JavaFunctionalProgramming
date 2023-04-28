package combinatorpattern.callbacks;

import java.util.function.Consumer;

public class Callbacks {
  public static void main(String[] args) {

    hello1("Michael", null, value -> {
      System.out.println("LastName not provided for: " + value);
    });

    hello2("Michael", null, () -> {
      System.out.println("LastName not provided");
    });
  }

  static void hello1(String firstName, String lastName, Consumer<String> callback) {
    System.out.println(firstName);
    if (lastName != null) {
      System.out.println(lastName);
    } else {
      callback.accept(firstName);
    }
  }

  static void hello2(String firstName, String lastName, Runnable callback) {
    System.out.println(firstName);
    if (lastName != null) {
      System.out.println(lastName);
    } else {
      callback.run();
    }
  }

  // Equivalent in JavaScript
  /*
   * function hello(firstName, lastName, callback) {
   * console.log(firstName);
   * if (lastName) {
   * console.log(lastName);
   * } else {
   * callback();
   * }
   * }
   * 
   * hello('Michael', null, function() {console.log('LastName not provided')})
   */
}
