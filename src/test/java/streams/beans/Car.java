package streams.beans;

public record Car(
    Integer id,
    String make,
    String model,
    String color,
    Integer year,
    Double price) {
}
