package 学习模块.collection;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueMain {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        try {
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.add(4);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.push("A");
        linkedList.add("B");

    }
}
