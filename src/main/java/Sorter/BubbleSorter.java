package Sorter;

import body.BaseContract;
import body.Repository;

import java.util.Comparator;

    /**
     * Сортировка пузырьком
     */
    public class BubbleSorter implements Isorter {

        @Override
        public Repository sort(Repository rep, int startIndex, int count, Comparator<BaseContract> comparator) {
            Repository sorted = rep.clone();

            for (int i = startIndex; i < count; i++)
                for (int j = startIndex + 1; j < (count - i); j++)
                    if (comparator.compare(sorted.getByID(j - 1), sorted.getByID(j)) > 0)
                        sorted.swap(j - 1, j);

            return sorted;
        }
    }

