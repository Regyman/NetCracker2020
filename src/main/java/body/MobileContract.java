package body;


/**
 * Класс Констракта на мобильную связь со свойствами <b>minutes</b>,<b>SMS</b>,<b>gigabytes</b>.
 * это класс-наследник , базовый класс можно увидеть здесь {@link BaseContract}
 * @author Никита Беленов
 * @version 1.0
 */
public class MobileContract  extends  BaseContract {

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /** Поле количество минут трафика */
    private Integer minutes;

    public void setSMS(Integer SMS) {
        this.SMS = SMS;
    }

    /** Поле количество смс */
    private Integer SMS;

    public void setGigabytes(Integer gigabytes) {
        this.gigabytes = gigabytes;
    }

    /** Поле количество гигабайт*/
    private Integer gigabytes;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - ID констракта
     * @param startDate - дата начала контракта
     * @param endDate - дата окончания контракта
     * @param owner - владелец контракта
     * @param minutes - количество минут трафика
     * @param sms - количество смс
     * @param gb - количество гигабайт
     * Этот конструктор использует конструктор базового класса , базовый конструктор {@link BaseContract#BaseContract(int, long, long, Client)}
     */
    public MobileContract(Integer id, Long startDate, Long endDate, Client owner, Integer minutes, Integer sms, Integer gb) {
        super(id, startDate, endDate, owner);

        this.minutes = minutes;
        this.SMS = sms;
        this.gigabytes = gb;
    }

    /**
     * Функция получения значения поля {@link MobileContract#minutes}
     * @return возвращает количество минут
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * Функция получения значения поля {@link MobileContract#SMS}
     * @return возвращает количество смс
     */
    public Integer getSMS() {
        return SMS;
    }

    /**
     * Функция получения значения поля {@link MobileContract#gigabytes}
     * @return возвращает количество гигабайт
     */
    public Integer getGigabytes() {
        return gigabytes;
    }

}
