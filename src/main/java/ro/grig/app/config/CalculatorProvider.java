package ro.grig.app.config;

import ro.grig.app.contracts.PolynomialOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CalculatorProvider {
    private final Map<String, Class<? extends PolynomialOperation>> bindings = new HashMap<>();
    private static final CalculatorProvider instance = new CalculatorProvider();

    public static <T extends  PolynomialOperation> void set(String key, Class<T> clazz) {
        instance.bindings.put(key, clazz);
    }
    public static Class<? extends PolynomialOperation> get(String key) {
        return instance.bindings.get(key);
    }
    public static Set<String> getAvailableOperations() { return instance.bindings.keySet(); }
}
