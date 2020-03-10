package com.test.test.sorting;

import java.util.Comparator;

public class Sorting implements Comparator<SortingModel> {

    @Override
    /**
     * ����
     */
    public int compare(SortingModel s1, SortingModel s2) {
        return s1.getAge() - s2.getAge();//�������С����
    }

}
