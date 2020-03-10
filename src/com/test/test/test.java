package com.test.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class test {
    int i = 10;

    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("2015-03-01 05");
        list.add("2015-03-01 03");
        list.add("2015-03-01 02");
        list.add("2015-03-01 01");
        Collections.sort(list);
        for (String string : list) {
            System.out.println(string);
        }
    }
}
