package functionalinterfaces;

import java.util.function.Predicate;

public class CustomPredicate {
  public static void main(String[] args) {
    String phoneNumber = "010000002";
    System.out.println(isPhoneNumberValid(phoneNumber));
    System.out.println(isPhoneNumberValidPredicate.test(phoneNumber));
    System.out.println(isPhoneNumberValidPredicate.and(containsPhoneNumberTwoPredicate).test(phoneNumber));

  }

  static boolean isPhoneNumberValid(String phoneNumber) {
    return phoneNumber.startsWith("01") && phoneNumber.length() == 9;
  }

  static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("01")
      && phoneNumber.length() == 9;

  static Predicate<String> containsPhoneNumberTwoPredicate = phoneNumber -> phoneNumber.contains("2");

}
