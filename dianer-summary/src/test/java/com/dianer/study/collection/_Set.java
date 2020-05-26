package 学习模块.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-04-25 15:16
 **/
public class _Set {

    private static TreeSet<String> treeSet = new TreeSet<>();
    private static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("A");

        hashSet.add("C");
        hashSet.add("B");
        hashSet.add("A");

        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Iterator<String> iterator2 = hashSet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

    }

}
