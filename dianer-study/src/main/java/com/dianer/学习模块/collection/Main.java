package com.dianer.学习模块.collection;

import java.util.Random;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<Object, String> map = new HashMap<>();
        System.out.println(map.toString());
        map.put(null, null);

        for (int i = 0; i < 99; i++) {
            System.out.println(i + " -- keyHash : ");
            map.put(new Key(), String.valueOf(i));
        }
        System.out.println(map.size());
        System.out.println(map.toString());
        Test<String> test = new Test<>();
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Key {
        int a;

        Key() {
            a = new Random().nextInt(10);
        }

        @Override
        public int hashCode() {
            int r = new Random().nextInt(5);
            System.out.println(" == hashCode : " + r);
            return r;
        }
    }

    static class Test<E> {
        int a;
    }

}

