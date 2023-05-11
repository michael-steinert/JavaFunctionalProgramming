package combinatorpattern;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    Customer customer = new Customer("Michael", "michael@mail.com", "0176", LocalDate.of(1994, 2, 2));
    CustomerValidatorService customerValidatorService = new CustomerValidatorService();
    System.out.println(customerValidatorService.isValid(customer));
    // Using Combinator Pattern
    CustomerValidator.ValidationResult validationResult = CustomerValidator.isEmailValid()
        .and(CustomerValidator.isPhoneNumberValid()).and(CustomerValidator.isAnAdult()).apply(customer);
    System.out.println(validationResult);
    if (validationResult != CustomerValidator.ValidationResult.SUCCESS) {
      throw new IllegalStateException(validationResult.name());
    }
  }
}
