package com.test.test.random;

import java.util.HashSet;
import java.util.Iterator;

public class Random {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        Random random = new Random();
        while (set.size() < 10) {
            int i = random.nextInt(90) + 10;
            set.add(i);
        }
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(set.size());
    }

    private int nextInt(int i) {
        // TODO Auto-generated method stub
        return 50;
    }

}
