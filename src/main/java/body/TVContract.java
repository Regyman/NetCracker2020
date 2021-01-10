package body;

/**
 * Класс Констракта на телевидение со свойством <b>tvPackage</b>.
 * это класс-наследник , базовый класс можно увидеть здесь {@link BaseContract}
 * @author Никита Беленов
 * @version 1.0
 */
public class TVContract  extends  BaseContract{

    public void setTvPackage(TVPackages tvPackage) {
        this.tvPackage = tvPackage;
    }

    /** Поле пакет каналов */
    private TVPackages tvPackage;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - ID констракта
     * @param startDate - дата начала контракта
     * @param endDate - дата окончания контракта
     * @param owner - владелец контракта
     * @param tvPackage - пакет каналов
     * Этот конструктор использует конструктор базового класса , базовый конструктор {@link BaseContract#BaseContract(int, long, long, Client)}
     */
    public TVContract(Integer id, Long startDate, Long endDate, Client owner, TVPackages tvPackage) {
        super(id, startDate, endDate, owner);

        this.tvPackage = tvPackage;
    }

    /**
     * Функция получения значения поля {@link TVContract#tvPackage}
     * @return возвращает пакет каналов
     */
    public TVPackages getTvPackage() {
        return tvPackage;
    }
}
