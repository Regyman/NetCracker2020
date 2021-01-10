package body;


import java.util.Calendar;
/**
 * Класс клиента со свойствами <b>ID</b> , <b>name</b>,<b>birthday</b>,<b>sex</b>,<b>passportS</b>,<b>passportN</b>.
 * @author Никита Беленов
 * @version 1.0
 */
public class Client {

    /**
     * Метод получения значения поля {@link Client#ID}
     * @return возвращает ID клиента
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Метод ,заданющий значение поля {@link Client#ID}
     * @param ID нужное значение
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /** Поле ID клиента */
    private Integer ID;

    /**
     * Метод ,заданющий значение поля {@link Client#fullName}
     * @param fullName нужное значение
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /** Поле ФИО клиента */
    private String fullName;

    /**
     * Метод ,заданющий значение поля {@link Client#birthday}
     * @param birthday нужное значение
     */
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    /** Поле дата рождения клиента */
    private Long birthday;


    /**
     * Метод ,заданющий значение поля {@link Client#sex}
     * @param sex нужное значение
     */
    public void setSex(Gender sex) {
        this.sex = sex;
    }

    /** Поле пол клиента */
    private  Gender sex;

    /**
     * Метод получения значения поля {@link Client#passportS}
     * @return значение passportS клиента
     */
    public Integer getPassportS() {
        return passportS;
    }

    /**
     * Метод ,заданющий значение поля {@link Client#passportS}
     * @param passportS нужное значение
     */
    public void setPassportS(Integer passportS) {
        this.passportS = passportS;
    }

    /** Поле серия паспорта клиента */
    private Integer passportS;

    /**
     * Метод получения значения поля {@link Client#passportN}
     * @return значение passportN клиента
     */
    public Integer getPassportN() {
        return passportN;
    }

    /**
     * Метод ,заданющий значение поля {@link Client#passportN}
     * @param passportN нужное значение
     */
    public void setPassportN(Integer passportN) {
        this.passportN = passportN;
    }

    /** Поле номер паспорта клиента */
    private Integer passportN;


    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param ID - ID констракта
     * @param fullName - ФИО клиента
     * @param birthday - дата рождения клиента
     * @param sex - пол клиента
     * @param passportS -  серия паспорта клиента
     * @param passportN -  номер паспорта клиента
     */
    public Client(Integer ID, String fullName, Long birthday, Gender sex, Integer passportS, Integer passportN){
        this.ID=ID;
        this.fullName=fullName;
        this.birthday= birthday;
        this.sex= sex;
        this.passportS= passportS;
        this.passportN= passportN;
    }


    /**
     * Метод получения возраста клиента
     * @return возвращает возраст клиента
     */
    public Integer getAge(){
        return age(birthday);
    }

    /**
     * Метод получения значения поля {@link Client#fullName}
     * @return возвращает ФИО клиента
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Метод получения значения поля {@link Client#birthday}
     * @return возвращает дату рождения клиента
     */
    public Long getBirthday() {
        return birthday;
    }

    /**
     * Метод получения значения поля {@link Client#sex}
     * @return возвращает пол клиента
     */
    public Gender getSex() {
        return sex;
    }

    /**
     * Метод получения значения поля {@link Client#passportS}
     * @return возвращает серию паспорта клиента
     */
    public Integer getPassportSeries() {
        return passportS;
    }

    /**
     * Метод получения значения поля {@link Client#passportN}
     * @return возвращает номер паспорта клиента
     */
    public Integer getPassportNumber() {
        return passportN;
    }

    /**
     * Метод подсчета возраста клиента
     * @param  birthday - дата рождения клиента
     * @return возвращает возраст клиента
     */
    public static Integer age(Long birthday) {
        long current = System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(current - birthday);
        return cal.get(Calendar.YEAR) - 1970;
    }

}
