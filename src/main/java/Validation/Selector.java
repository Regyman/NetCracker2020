package Validation;

    /**
     * Интерфейс для выбора полей для проверки
     * @param <T> объект для проверки
     * @param <E> поле из объекта для проверки
     */
    @FunctionalInterface
    public interface Selector<T, E> {
        T select(E object);
    }

