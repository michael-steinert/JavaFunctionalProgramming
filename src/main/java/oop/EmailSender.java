package oop;

public class EmailSender {
  public void useOop() {
    String name = "Bruno";
    IEmailSender emailSender = new IEmailSender() {
      @Override
      public boolean send(String name) {
        System.out.println("Hallo %s".formatted(name));
        return !name.isEmpty();
      }
    };
    boolean isEmailSent = emailSender.send(name);
  }

  public void useFunctionalProgramming() {
    String name = "Bruno";
    IEmailSender emailSender = (n) -> {
      System.out.println("Hallo %s".formatted(n));
      return !n.isEmpty();
    };
    boolean isEmailSent = emailSender.send(name);
  }
}
