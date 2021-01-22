package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class _Optional {
    public static void main(String[] args) {
        Supplier<IllegalStateException> illegalStateExceptionSupplier =
                () -> new IllegalStateException("Exception");

        Object optionalValue = Optional.ofNullable("Value")
                .orElseThrow(illegalStateExceptionSupplier);

    }
}
