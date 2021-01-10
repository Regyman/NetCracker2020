package body;


import Sorter.BubbleSorter;
import Sorter.Isorter;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Класс констракта со свойствами <b>data</b> , <b>size</b>,<b>Extension</b>.
 * @author Никита Беленов
 * @version 1.0
 */

public class Repository {

    /** Поле массив объектов*/
    private BaseContract[] data;

    /**
     * Получает размер массива
     */
    public int getSize() {
        return size;
    }

    /**
     * Задает размер массива
     *
     * @param size размер создаваемого массива
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /** Поле размер репозитория*/
    private int size;
    /** Поле базовый размер увеличения массива*/
    private static final int  Extension =10;
    /**Поле тип сортировки */
    private Isorter sorter;
    /**
     * Получает тип сортировки
     */
    public Isorter getSorter() {
        return sorter;
    }
    /**
     * Задает тип сортировки
     *
     * @param sorter выбор типа сортировки
     */
    public void setSorter(Isorter sorter) {
        this.sorter = sorter;
    }

    /**
     * Конструкторы - создание нового объекта с определенными значениями
     */

    public Repository(){
        size = 0;
        data = new BaseContract[0];
        sorter = new BubbleSorter();
    }
    public Repository(Repository rep) {
        this.data = rep.data;
        this.size = rep.size;
        this.sorter = rep.sorter;
    }

    /**
     * Функция увеличения размера массива(внутренняя) {@link Repository#data}
     * @param num - число на которое увеличится размер массива
     */
    private void expandmas(Integer num){
        BaseContract[] temp = data.clone();
        data = new BaseContract[data.length+num];
        System.arraycopy(temp, 0, data, 0, temp.length);
    }

    /**
     * Функция увеличения размера массива(внешняя) {@link Repository#data}
     */
    private void expand(){
        expandmas(Extension);
    }


    /**
     * Функция проверки массива на заполненность {@link Repository#data}
     */
    private boolean isFull(){
        return size >= data.length;
    }

    /**
     * Функция проверки массива на пустоту {@link Repository#data}
     */
    public boolean isNull(){
        return size == 0;
    }

    /**
     * Функция добавления элемента в репозиторий {@link Repository#data}
     * @param  element - элемент который необходимо добавить
     */
    public void add(BaseContract element){
        if(isFull())
        {
            expand();
        }

        data[size++]=element;
    }

    /**
     * Функция добавления элемента в репозиторий {@link Repository#data}
     * @param  ID - ID элемента который необходимо удалить
     * @return возвращает удаленный элемент
     */
    public BaseContract delete(Integer ID){
        if(isNull() || ID>= size || ID<0)
        {
            return null;
        }

        size=size-1;
        BaseContract element = data[ID];
        System.arraycopy(data, ID + 1, data, ID, size - ID);
        data[size] = null;

        return  element;

    }

    /**
     * Функция добавления нахождения элемента  в репозитории по ID {@link Repository#data}
     * @param  ID - ID элемента для его поиска
     * @return возвращает найденный элемент
     */
    public BaseContract getByID(Integer ID)
    {
        if(isNull() || ID>= size || ID<0)
        {
            return null;
        }

        return data[ID];
    }


    public BaseContract getByPosition(int position) {
        return data[position];
    }


    private int getPositionById(int id) {
        for (int i = 0; i <= size; i++) {
            if (data[i].getID() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Метод, котороый ищет констракт в репозитории
     *
     * @param id id искомого контракта
     * @return найденный контракт или null
     */
    public BaseContract getBaseContractById(int id) {
        int pos = getPositionById(id);
        if (pos == -1) return null;
        else return data[pos];
    }

    /**
     * Метод, создающий новый репозиторий, идентичный данному
     *
     * @return новый репозиторий
     */
    @Override
    public Repository clone() {

        try {
           super.clone();
        } catch (CloneNotSupportedException ignored) {

        }
        return new Repository(this);
    }

    /**
     * Метод, меняющий местами контракты в репозитории
     *
     * @param first позиция первого контракта
     * @param second позиция второго контракта
     */
    public void swap(int first, int second) {
        BaseContract temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }


    /**
     * Метод, сортирующий репозиторий по зданному критерию
     *
     * @param comparator критерий для сравнения
     * @return отсортированный репзиторий
     */
    public Repository sort(Comparator<BaseContract> comparator) {
        return sorter.sort(this, 0, size, comparator);
    }

    /**
     * Метод создает новый репозиторий с отфильтрованными констрактами
     *
     * @param predicate условие для фильтра
     * @return новый Repository с отсрортированными значениями
     */
    public Repository filter(Predicate<BaseContract> predicate) {
        Repository filtered = new Repository();

        for (int i = 0; i < size; i++) {
            BaseContract element = data[i];
            if (predicate.test(element))
                filtered.add(element);
        }
        return filtered;
    }
}
