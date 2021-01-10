package body;


/**
 * Класс Констракта на интернет со свойством <b>ConnectionSpeed</b>.
 * это класс-наследник , базовый класс можно увидеть здесь {@link BaseContract}
 * @author Никита Беленов
 * @version 1.0
 */
public class InternetContract extends BaseContract{

    public void setConnectionSpeed(Integer connectionSpeed) {
        ConnectionSpeed = connectionSpeed;
    }

    /** Поле скорость интернет соединения */
    private Integer ConnectionSpeed;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - ID констракта
     * @param startDate - дата начала контракта
     * @param endDate - дата окончания контракта
     * @param owner - владелец контракта
     * @param  ConnectionSpeed - скорость интернет соединения
     * Этот конструктор использует конструктор базового класса , базовый конструктор {@link BaseContract#BaseContract(int, long, long, Client)}
     */
    public InternetContract(Integer id, Long startDate, Long endDate, Client owner, Integer ConnectionSpeed) {
        super(id, startDate, endDate, owner);
        this.ConnectionSpeed = ConnectionSpeed;
    }


    /**
     * Функция получения значения поля {@link InternetContract#ConnectionSpeed }
     * @return возвращает скорость интернет соединения
     */
    public Integer ConnectionSpeed() {
        return ConnectionSpeed;
    }
}