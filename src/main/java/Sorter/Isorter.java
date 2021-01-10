package Sorter;

import body.BaseContract;
import body.Repository;

import java.util.Comparator;
/**Интерфейс для сортировки репозиториев*/
public interface Isorter {
    /**Метод дял сортировки репозиториев
     * @param  rep репозиторий для сортировки
     * @param  startIndex начальный индекс
     * @param  count счетчик
     * @param  comparator компаратор*/

    public Repository sort(Repository rep, int startIndex, int count, Comparator<BaseContract> comparator);
}