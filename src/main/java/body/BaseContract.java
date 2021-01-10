package body;

/**
 * Класс констракта со свойствами <b>ID</b> , <b>startDate</b>,<b>endDate</b>,<b>owner</b>.
 * @author Никита Беленов
 * @version 1.0
 */
public  class BaseContract {

    /**Метод, задющий значение ID
     * @param  ID нужное значение
     * */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /** Поле ID контракта */
    private Integer ID;

    /**Метод, задющий значение startDate
     * @param  startDate нужное значение
     * */
    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    /** Поле дата начала контракта */
    private Long startDate;

    /**Метод, задющий значение endDate
     * @param  endDate нужное значение
     * */
    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    /** Поле дата окончания контракта*/
    private Long endDate;
    /**Метод, задющий значение owner
     * @param  owner нужное значение
     * */
    public void setOwner(Client owner) {
        this.owner = owner;
    }

    /** Поле владелец контракта*/
    private Client owner;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param ID - ID констракта
     * @param startDate - дата начала контракта
     * @param endDate - дата окончания контракта
     * @param owner - владелец контракта
     */
    public BaseContract(int ID, long startDate,long endDate, Client owner){
        this.ID=ID;
        this.startDate=startDate;
        this.endDate=endDate;
        this.owner=owner;
    }

    /**
     * Функция получения значения поля {@link BaseContract#ID}
     * @return возвращает ID констракта
     */
    public int getID(){
        return ID;
    }

    /**
     * Функция получения значения поля {@link BaseContract#startDate}
     * @return возвращает дату начала констракта
     */
    public long getStartDate(){
        return  startDate;
    }

    /**
     * Функция получения значения поля {@link BaseContract#endDate}
     * @return возвращает дату окончания констракта
     */
    public long getEndDate(){
        return endDate;
    }


    /**
     * Функция получения значения поля {@link BaseContract#owner}
     * @return возвращает владельца констракта
     */
    public Client getOwner(){
        return owner;
    }

}