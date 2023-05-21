# Java Functional Programming

- Functional Programming is a Programming Paradigm based on the Concept of Functions
- It allows Functions to be treated in the same Way as other Values, such as Integers or Strings, giving them the same Capabilities
- This allows the Creation of Pure Functions, i.e. Functions that, given the same Input, always return the same Output and have no Side Effects

## Key Features of Functional Programming

- Functional Programming has a Number of Key Features, including Immutability, referential Transparency, and the Use of Higher-Order Functions
- In Functional Programming, Data is often immutable, meaning that it can not be changed once it has been created. This can make it easier to reason about Programs and help avoid common Programming Errors
- Referential Transparency refers to the Property of an Expression that can be replaced by its Value without changing the Meaning of a Program
- Higher-Order Functions are Functions that take other Functions as Input or return a Function as Output

## Declarative Programming Paradigm

- Functional Programming is a declarative Programming Paradigm, which means that the Focus is on what the Program should do, rather than how it should do it
- It can make it easier to write Programs that are concise, readable and maintainable

## Properties of Functional Programming

### No State

- In Functional Programming, it is often considered Best Practice to avoid Using State, or to minimize its use
- This means that Programs should not rely on the Value of global Variables or other external Factors to function properly
- Instead, Programs should be self-contained, using Input Parameters and Return Values to communicate with the Rest of the Program
- Avoiding State has a Number of Advantages as follows:
  - Programs are easier to understand, because the Behavior of the Program does not depend on external Factors
  - Programs are easier to test, because they can be tested in Isolation from the Rest of the Program
  - Programs are more modular because they can be combined and reused in different Contexts
  - Programs are more resistant to change, because Changes to the State of the Program do not affect the Behavior of the Program
- There are the following Ways to avoid State in Functional Programming:
  - One Approach is to use immutable Data, which means that Data can not be changed once it has been created. This can help avoid the Need to update global Variables or other external State
  - Another Approach is to use Pure Functions, which are Functions that always return the same Output given the same Input, and have no Side Effects
- This can help ensure that the Behavior of the Program is predictable and does not depend on External Factors
- Finally, it can be helpful to use Function Composition, which is the Process of Combining small, modular Functions to create more complex Programs
- This can help avoid the Need to use global State, and can make Programs more reusable and maintainable

### Immutability

- Data is often immutable, meaning that it can not be changed once it has been created
- This can make it easier to think about Programs and can help avoid common Programming Errors

### Higher Order Functions

- Programs often use Higher-Order Functions, which are Functions that take other Functions as Input or Return a Function as Output. This allows the Creation of reusable, modular code

### Pure Functions

- A Pure Function is a Function that, given the same Input, always returns the same Output and has no Side Effects
- This makes Pure Functions predictable, easy to understand and easy to test

## Java Stream

- Java Streams are a functional and concise Abstraction for processing Data Collections (like Lists, Maps, Sets and Arrays)
- Java Streams enable high-level Operations on the Data as a whole, promoting Code Readability and Efficiency

## Lambdas

- In Java, Lambdas are a Feature that allows Developers to define small, anonymous Functions that can be passed as Arguments to other Methods or assigned to Variables. These Functions are able to capture their surrounding Context, which means that they can access Variables from the Scope in which they are defined
- Lambdas can be used in Conjunction with Functional Interfaces, which are Interfaces that define a single abstract Method. A Lambda Expression can be used as a Shorthand Way of Creating an Instance of a Functional Interface, and can be passed as an Argument to a Method or Constructor that takes a Functional Interface
- One of the Benefits of using Lambdas is the Ability to write more concise and readable Code by using less Boilerplate and Providing a more direct Expression of the intended Behavior. This can make the Code more expressive and easier to understand and maintain
- In Addition, Lambdas are useful for providing a concise Way of Defining Behavior that can be passed as Arguments, allowing for more flexible and modular Code

```java
import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    Function<Integer, Integer> square = x -> x * x;
    System.out.println(square.apply(4));
  }
}
```

## Method References

- In Java, Method References are a Way of Referring to a Method of an existing Class or Object without having to call it
- Method References are used as Shorthand for a Lambda Expression that simply calls an existing Method
- Method references can be used with Functional Interfaces, which are Interfaces that define a single abstract Method
- There are the following four Types of Method Reference:
  - Reference to a static Method
  - Reference to an Instance Method of a specific Object
  - Reference to an Instance Method of any Object of a given Type
  - Reference to a Constructor
- Method References can be used in Place of a Lambda Expression calling the same Method, and can make Code more concise and readable

```java
import java.util.Arrays;
import java.util.List;

public class LambdaMethodReferenceExample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3);
    // Lambda Expression
    numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
    // Method Reference
    numbers.stream().filter(LambdaMethodReferenceExample::isNumberEven).forEach(System.out::println);
  }
  private static boolean isNumberEven(int number) {
    return number % 2 == 0;
  }
}
```

## forEach

- In Java, the `forEach` Method is a Way of Iterating over the Elements of a Collection, such as a List or a Set, and performing a specific Action on each Element
- The `forEach` Method takes a single Argument, which is a Function that can be applied to each Element in the Collection. This Function is defined using a Functional Interface, such as Consumer, which defines a single abstract Method, accept, that takes an Element of the Collection as an Argument and performs an action on it
- The `forEach` Method applies the Function to each Element of the Collection and can be used to perform a variety of Actions on the Elements of the Collection, such as Printing them to the Console, Adding them to another Collection, or Modifying them in some way
- One of the Benefits of using the `forEach` Method is its Ability to make Code more concise, readable and expressive

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("Bruno");
    names.add("Michael");
    names.forEach(name -> System.out.println(name));
  }
}
```
