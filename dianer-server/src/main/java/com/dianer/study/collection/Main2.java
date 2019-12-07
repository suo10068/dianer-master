package com.dianer.study.collection;

import java.util.HashMap;
import java.util.Random;

/**
 * 为什么要重写hashcode 和 equals方法
 */
public class Main2 {

    public static void main(String[] args) {
        HashMap<Object, String> map = new HashMap<>();
        Student a = new Student(1, "a");
        Student b = new Student(1, "b");
        Student c = new Student(2, "c");
        Student d = new Student(3, "c");

        map.put(a, "a");
        map.put(b, "b");
        map.put(c, "c");
        map.put(d, "d");
        System.out.println("==============");

        System.out.println("a equals b:" + a.equals(b));
        System.out.println("map size:" + map.size());
        System.out.println("a:" + map.get(new Student(1, "a")));
        System.out.println("b:" + map.get(new Student(2, "c")));
    }


    static class Student {
        int id;
        String name;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Student)) return false;
            Student s = (Student) obj;
            if (s.id == this.id && s.name.equals(this.name)) return true;
            return false;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + id;
//            result = 31 * result + (mBoolean ? 1 : 0);
//            result = 31 * result + Float.floatToIntBits(mFloat);
//            result = 31 * result + (int)(mLong ^ (mLong >>> 32));
//            long mDoubleTemp = Double.doubleToLongBits(mDouble);
//            result =31 * result + (int)(mDoubleTemp ^ (mDoubleTemp >>> 32));
//            result = 31 * result + (mString == null ? 0 : mMsgContain.hashCode());
//            result = 31 * result + (mObj == null ? 0 : mObj.hashCode());
            return result;

        }
    }

}

