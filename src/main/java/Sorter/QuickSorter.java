package Sorter;

import body.BaseContract;
import body.Repository;

import java.util.Comparator;


/**
 * Быстрая сортировка
 */
public class QuickSorter implements Isorter {
    @Override
    public Repository sort(Repository rep, int startIndex, int count, Comparator<BaseContract> comparator) {
        Repository sorted = rep.clone();

        quickSort(sorted, startIndex, count - 1, comparator);

        return sorted;
    }

    private void quickSort(Repository rep, int startIndex, int endIndex, Comparator<BaseContract> comparator) {
        if (startIndex < endIndex) {
            int partitionIndex = partition(rep, startIndex, endIndex, comparator);

            quickSort(rep, startIndex, partitionIndex - 1, comparator);
            quickSort(rep, partitionIndex + 1, endIndex, comparator);
        }
    }


    private int partition(Repository rep, int startIndex, int endIndex, Comparator<BaseContract> comparator) {
        int i = startIndex - 1;

        for (int j = startIndex; j < endIndex; j++)
            if (comparator.compare(rep.getByID(j), rep.getByID(endIndex)) < 0)
                rep.swap(++i, j);

        rep.swap(++i, endIndex);

        return i;
    }


}