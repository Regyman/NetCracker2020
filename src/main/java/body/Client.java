package body;


import java.util.Calendar;
/**
 * Класс клиента со свойствами <b>ID</b> , <b>name</b>,<b>birthday</b>,<b>sex</b>,<b>passportS</b>,<b>passportN</b>.
 * @author Никита Беленов
 * @version 1.0
 */
public class Client {
    /** Поле ID клиента */
    private Integer ID;
    /** Поле ФИО клиента */
    private String fullName;
    /** Поле дата рождения клиента */
    private Long birthday;
    /** Поле пол клиента */
    private  Gender sex;
    /** Поле серия паспорта клиента */
    private Integer passportS;
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
     * Функция получения значения поля {@link Client#ID}
     * @return возвращает ID клиента
     */
    public Integer getId() {
        return ID;
    }

    /**
     * Функция получения возраста клиента
     * @return возвращает возраст клиента
     */
    public Integer getAge(){
        return age(birthday);
    }

    /**
     * Функция получения значения поля {@link Client#fullName}
     * @return возвращает ФИО клиента
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Функция получения значения поля {@link Client#birthday}
     * @return возвращает дату рождения клиента
     */
    public Long getBirthday() {
        return birthday;
    }

    /**
     * Функция получения значения поля {@link Client#sex}
     * @return возвращает пол клиента
     */
    public Gender getSex() {
        return sex;
    }

    /**
     * Функция получения значения поля {@link Client#passportS}
     * @return возвращает серию паспорта клиента
     */
    public Integer getPassportSeries() {
        return passportS;
    }

    /**
     * Функция получения значения поля {@link Client#passportN}
     * @return возвращает номер паспорта клиента
     */
    public Integer getPassportNumber() {
        return passportN;
    }

    /**
     * Функция подсчета возраста клиента
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
