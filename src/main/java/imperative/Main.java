package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Michael", Person.Gender.MALE),
                new Person("Magnus", Person.Gender.MALE),
                new Person("Marie", Person.Gender.FEMALE),
                new Person("Melanie", Person.Gender.FEMALE)
        );

        // Imperative Approach
        List<Person> femaleList = new ArrayList<>();

        for(Person person : personList) {
            if(Person.Gender.FEMALE.equals(person.gender)) {
                femaleList.add(person);
            }
        }

        for(Person female : femaleList) {
            System.out.println(female);
        }
        
        // Declarative Approach
        personList.stream()
                .filter(person -> Person.Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(person -> System.out.println(person));
    }

    static class Person {
        private final String name;
        private final Gender gender;

        enum Gender {
            MALE, FEMALE
        }

        public Person(String name, Gender gender) {
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
