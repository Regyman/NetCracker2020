package Validation;

/**
 * Класс для уловий валидации
 * @param <E> поле для валидации
 */
public class Condition<E> {
    private final Object expected;
    private final Verifier<Object> verifier;
    private final Selector<Object, E> selector;
    private Conditions type;

    /**
     * Конструктор
     * @param expected Ожидаемое значение
     * @param selector поле для проерки
     * @param verifier Верификатор
     * @param <T> тип
     */
    @SuppressWarnings("unchecked")
    public <T> Condition(T expected, Selector<T, E> selector, Verifier<T> verifier) {
        this.expected = expected;
        this.selector = (Selector<Object, E>) selector;
        this.verifier = (Verifier<Object>) verifier;
    }

    /**
     * Конструктор
     * @param expected ожидаемое значение
     * @param selector поле для проверки
     * @param <T> тип
     */
    @SuppressWarnings("unchecked")
    public <T> Condition(T expected, Selector<T, E> selector) {
        this.expected = expected;
        this.type = Conditions.EQUALS;
        this.selector = (Selector<Object, E>) selector;
        this.verifier = Object::equals;
    }

    /**
     * Конструктор
     * @param expected ожидаемое значение
     * @param type тип условия
     * @param selector селектор
     * @param verifier Верификатор
     * @param <T> тип
     */
    @SuppressWarnings("unchecked")
    public <T> Condition(T expected, Conditions type, Selector<T, E> selector, Verifier<T> verifier) {
        this.expected = expected;
        this.type = type;
        this.selector = (Selector<Object, E>) selector;
        this.verifier = (Verifier<Object>) verifier;
    }

    public Object getExpected() {
        return expected;
    }

    public Verifier<Object> getVerifier() {
        return verifier;
    }

    public Conditions getType() {
        return type;
    }

    public Selector<Object, E> getSelector() {
        return selector;
    }
}
