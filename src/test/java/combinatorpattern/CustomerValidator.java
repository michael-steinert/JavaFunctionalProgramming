package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import combinatorpattern.CustomerValidator.ValidationResult;

public interface CustomerValidator extends Function<Customer, ValidationResult> {

  static CustomerValidator isEmailValid() {
    return customer -> customer.email().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
  }

  static CustomerValidator isPhoneNumberValid() {
    return customer -> customer.phoneNumber().startsWith("0") ? ValidationResult.SUCCESS
        : ValidationResult.PHONE_NUMBER_NOT_VALID;
  }

  static CustomerValidator isAnAdult() {
    return customer -> Period.between(customer.dob(), LocalDate.now()).getYears() > 18 ? ValidationResult.SUCCESS
        : ValidationResult.IS_NOT_AN_ADULT;
  }

  default CustomerValidator and(CustomerValidator other) {
    return customer -> {
      ValidationResult validationResult = this.apply(customer);
      return validationResult.equals(ValidationResult.SUCCESS) ? other.apply(customer) : validationResult;
    };
  }

  enum ValidationResult {
    SUCCESS,
    EMAIL_NOT_VALID,
    PHONE_NUMBER_NOT_VALID,
    IS_NOT_AN_ADULT
  }
}
