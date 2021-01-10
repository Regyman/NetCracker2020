package Validation;

/**
 * Интерфейс для верификаторов
 * @param <T> тип верификации
 */
@FunctionalInterface
public interface Verifier<T> {
    boolean verify(T expected, T actual);
}