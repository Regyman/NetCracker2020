package body;


/**
 * Класс констракта со свойствами <b>data</b> , <b>size</b>,<b>Extension</b>.
 * @author Никита Беленов
 * @version 1.0
 */

public class Repository<T> {

    /** Поле массив объектов*/
    private Object[] data;
    /** Поле размер репозитория*/
    private Integer size;
    /** Поле базовый размер увеличения массива*/
    private static final int  Extension =10;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     */
    public Repository(){
        size=0;
        data= new Object[size];
    }

    /**
     * Функция увеличения размера массива(внутренняя) {@link Repository#data}
     * @param num - число на которое увеличится размер массива
     */
    private void ExpandMas(Integer num){
        Object[] temp = data.clone();
        data = new Object[data.length + num];
        System.arraycopy(temp, 0, data, 0, temp.length);
    }

    /**
     * Функция увеличения размера массива(внешняя) {@link Repository#data}
     */
    private void Expand(){
        ExpandMas(Extension);
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
    public void add(T element){
        if(isFull())
        {
            Expand();
        }

        data[size++]=element;
    }

    /**
     * Функция добавления элемента в репозиторий {@link Repository#data}
     * @param  ID - ID элемента который необходимо удалить
     * @return возвращает удаленный элемент
     */
    public T delete(Integer ID){
        if(isNull() || ID>= size || ID<0)
        {
            return null;
        }

        size=size-1;
        Object element = data[ID];
        System.arraycopy(data, ID + 1, data, ID, size - ID);
        data[size] = null;

        return (T) element;

    }

    /**
     * Функция добавления нахождения элемента  в репозитории по ID {@link Repository#data}
     * @param  ID - ID элемента для его поиска
     * @return возвращает найденный элемент
     */
    public T getByID(Integer ID)
    {
        if(isNull() || ID>= size || ID<0)
        {
            return null;
        }

        return (T) data[ID];
    }
}
