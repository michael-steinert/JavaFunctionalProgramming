package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Person> persons = List.of(
        new Person("Michael", Person.Gender.MALE),
        new Person("Bruno", Person.Gender.MALE),
        new Person("Marie", Person.Gender.FEMALE),
        new Person("Melanie", Person.Gender.FEMALE));

    // Imperative Approach
    List<Person> females = new ArrayList<>();

    for (Person person : persons) {
      if (Person.Gender.FEMALE.equals(person.gender)) {
        females.add(person);
      }
    }

    for (Person female : females) {
      System.out.println(female);
    }

    // Declarative Approach
    persons.stream()
        .filter(person -> Person.Gender.FEMALE.equals(person.gender))
        .collect(Collectors.toList())
        .forEach(person -> System.out.println(person));
  }

  private static record Person(String name, Gender gender) {
    enum Gender {
      MALE, FEMALE
    }
  }
}
