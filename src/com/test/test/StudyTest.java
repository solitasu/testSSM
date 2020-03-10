package com.test.test;

import java.util.Calendar;
import java.util.Date;

public class StudyTest {
    public static void main(String[] args) {
        /** ��ȡ��ǰ��֮��ʱ��
         *  Wed Mar 01 17:00:15 CST 2017
         1488358815195
         Wed Mar 01 17:00:15 CST 2017
         1488358815238
         2017��3��1��5ʱ0��15��
         2017��4��20��
         */
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());//���ظ�������ʱ��֮��ĺ�����
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.getTimeInMillis());//���ظ�������ʱ��֮��ĺ�����
        System.out.println(cal.get(Calendar.YEAR) + "��" + (cal.get(Calendar.MONTH) + 1) + "��" + cal.get(Calendar.DATE) + "��" + cal.get(Calendar.HOUR) + "ʱ" + cal.get(Calendar.MINUTE) + "��" + cal.get(Calendar.SECOND) + "��");
        cal.add(Calendar.DATE, 50);//�����50���ʱ��
        System.out.println(cal.get(Calendar.YEAR) + "��" + (cal.get(Calendar.MONTH) + 1) + "��" + cal.get(Calendar.DATE) + "��");

    }
}
