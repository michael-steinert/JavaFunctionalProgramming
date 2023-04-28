package functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CustomFunction {
  public static void main(String[] args) {
    int increment1 = increment(1);
    System.out.println(increment1);
    int increment2 = incrementByOneFunction.apply(1);
    System.out.println(increment2);
    int multiply = multipleByTenFunction.apply(increment2);
    System.out.println(multiply);
    Function<Integer, Integer> incrementByOnAndThenMultipleByTen = incrementByOneFunction
        .andThen(multipleByTenFunction);
    int incrementAndThenMultiple = incrementByOnAndThenMultipleByTen.apply(1);
    System.out.println(incrementAndThenMultiple);
    int incrementAndMultiply = incrementFirstNumberAndMultipleWithSecondNumberFunction.apply(1, 10);
    System.out.println(incrementAndMultiply);
  }

  private static int increment(int number) {
    return number + 1;
  }

  // Function<Input, Output> functionName = Parameter -> Logic
  private static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

  private static Function<Integer, Integer> multipleByTenFunction = number -> number * 10;

  // BiFunction<Input1, Input2, Output> functionName = (Parameter1, Parameter2) ->
  // Logic
  private static BiFunction<Integer, Integer, Integer> incrementFirstNumberAndMultipleWithSecondNumberFunction = (
      number1, number2) -> (number1 + 1) * number2;
}
