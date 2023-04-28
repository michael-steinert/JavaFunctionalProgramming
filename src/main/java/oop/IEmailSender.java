package oop;

@FunctionalInterface
public interface IEmailSender {
  boolean send(String message);

  default void defaultFunction() {
    System.out.println("Functional Interface");
  }
}
