package body;


/**
 * Класс Констракта на мобильную связь со свойствами <b>minutes</b>,<b>sms</b>,<b>gigabytes</b>.
 * это класс-наследник , базовый класс можно увидеть здесь {@link BaseContract}
 * @author Никита Беленов
 * @version 1.0
 */
public class MobileContract  extends  BaseContract {

    /**
     * Метод ,заданющий значение поля {@link MobileContract#minutes}
     * @param minutes нужное значение
     */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    /** Поле количество минут трафика */
    private Integer minutes;

    /**
     * Метод ,заданющий значение поля {@link MobileContract#sms}
     * @param sms нужное значение
     */
    public void setSms(Integer sms) {
        this.sms = sms;
    }

    /** Поле количество смс */
    private Integer sms;

    /**
     * Метод ,заданющий значение поля {@link MobileContract#gigabytes}
     * @param gigabytes нужное значение
     */
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
        this.sms = sms;
        this.gigabytes = gb;
    }

    /**
     * Метод получения значения поля {@link MobileContract#minutes}
     * @return возвращает количество минут
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * Метод получения значения поля {@link MobileContract#sms}
     * @return возвращает количество смс
     */
    public Integer getSms() {
        return sms;
    }

    /**
     * Метод получения значения поля {@link MobileContract#gigabytes}
     * @return возвращает количество гигабайт
     */
    public Integer getGigabytes() {
        return gigabytes;
    }

}
