package streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {
  public static void main(String[] args) {

    List<Person> personList = List.of(
        new Person("Michael", Person.Gender.MALE),
        new Person("Magnus", Person.Gender.MALE),
        new Person("Marie", Person.Gender.FEMALE),
        new Person("Melanie", Person.Gender.FEMALE));

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

  static class Person {
    private final String name;
    private final Person.Gender gender;

    enum Gender {
      MALE, FEMALE
    }

    public Person(String name, Person.Gender gender) {
      this.name = name;
      this.gender = gender;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", gender=" + gender +
          '}';
    }
  }
}
