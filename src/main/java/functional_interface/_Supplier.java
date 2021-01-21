package functional_interface;

import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getName());

        System.out.println(getNameSupplier.get());
    }

    static String getName() {
        return "Michael";
    }

    static Supplier<String> getNameSupplier = () -> "Michael";
}
