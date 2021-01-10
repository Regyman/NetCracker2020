package body;


/**
 * Класс Констракта на интернет со свойством <b>connectionSpeed</b>.
 * это класс-наследник , базовый класс можно увидеть здесь {@link BaseContract}
 * @author Никита Беленов
 * @version 1.0
 */
public class InternetContract extends BaseContract{

    /**
     * Метод ,заданющий значение поля {@link InternetContract#connectionSpeed}
     * @param connectionSpeed нужное значение
     */
    public void setConnectionSpeed(Integer connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }

    /** Поле скорость интернет соединения */
    private Integer connectionSpeed;

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
        this.connectionSpeed = ConnectionSpeed;
    }


    /**
     * Метод получения значения поля {@link InternetContract#connectionSpeed }
     * @return возвращает скорость интернет соединения
     */
    public Integer ConnectionSpeed() {
        return connectionSpeed;
    }
}