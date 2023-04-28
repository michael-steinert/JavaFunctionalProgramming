package functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
  public static void main(String[] args) {
    Person person = new Person("Michael", 26);

    greetPerson(person);

    greetPersonConsumer.accept(person);

    greetPersonShowAge.accept(person, false);
  }

  // Consumer<Input> functionName = Parameter -> Logic. Output is void.
  private static Consumer<Person> greetPersonConsumer = person -> System.out
      .println("Hello " + person.name + ". Your Age is: " + person.age + ".");

  // BiConsumer<Input1, Input2> functionName = (Parameter1, Parameter2) -> Logic.
  // Output is void.
  private static BiConsumer<Person, Boolean> greetPersonShowAge = (person, showAge) -> System.out
      .println("Hello " + person.name + (showAge ? ". Your Age is: " + person.age + "." : ""));

  private static void greetPerson(Person person) {
    System.out.println("Hello " + person.name + ". Your Age is: " + person.age + ".");
  }

  private static class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }
}
