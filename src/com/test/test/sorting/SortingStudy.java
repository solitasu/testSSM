package com.test.test.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class SortingStudy {

    /**
     * ����
     * �����5
     * ����
     * ����
     * ����
     * ����
     * �һ��˸�����
     */
    public static void main(String[] args) {
        ArrayList<SortingModel> list = new ArrayList<SortingModel>();
        SortingModel zhangsan = new SortingModel("����", 11);
        SortingModel lisi = new SortingModel("����", 17);
        SortingModel wangwu = new SortingModel("����", 13);
        SortingModel wangbo = new SortingModel("����", 15);
        list.add(zhangsan);
        list.add(lisi);
        list.add(wangwu);
        list.add(wangbo);
        list.add(1, wangwu);  //�ڵ�һλ��������
        list.get(2).setName("�һ��˸�����");  //���ڶ������ֻ������
        System.out.println(list.size());
        Collections.sort(list, new Sorting());//����

        for (SortingModel s : list) { //foreach���
            System.out.println(s.getName());
        }
    }
}
