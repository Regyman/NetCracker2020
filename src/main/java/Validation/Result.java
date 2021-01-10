package Validation;


/**
 * Класс с результатами проверки
 */
public class Result {
    private final boolean isValid;
    private final String message;

    /**
     * Конструктор
     * @param isValid главный результат проверки
     * @param message сообщение об ошибке
     */
    public Result(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    /**
     * Метод, возвращающий состояние isValid
     * @return состояние isValid
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Метод, возвращающий сообщение
     * @return сообщение
     */
    public String getMessage() {
        return message;
    }
}
