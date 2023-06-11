package streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomStream {
  public static void main(String[] args) {

    List<Person> personList = List.of(
        new Person("Michael", Person.Gender.MALE),
        new Person("Bruno", Person.Gender.MALE),
        new Person("Marie", Person.Gender.FEMALE),
        new Person("Bella", Person.Gender.FEMALE));

    Function<Person, String> personStringFunction = person -> person.name;

    Function<String, Integer> stringIntegerFunction = name -> name.length();

    Consumer<Integer> integerConsumer = nameLength -> System.out.println(nameLength);

    personList.stream()
        .map(personStringFunction)
        .map(stringIntegerFunction)
        .forEach(integerConsumer);

    Predicate<Person> personPredicate = person -> Person.Gender.MALE.equals(person.gender);

    boolean allMatchContainsMales = personList.stream()
        .allMatch(personPredicate);

    System.out.println(allMatchContainsMales);
  }

  public static record Person(String name, Gender gender) {
    enum Gender {
      MALE, FEMALE
    }
  }
}
