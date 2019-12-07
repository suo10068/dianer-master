package com.dianer.study.学习.数据结构;

import java.util.Stack;

/**
 * 链表
 */
public class LinkedList {

    Node root;
    Node last;

    LinkedList() {

    }

    void add(int index) {
        if (root == null) {
            root = new Node(index);
            last = root;
        } else if (last != null) {
            Node temp = new Node(index);
            last.next = temp;
            last = temp;
        }
    }


    public static void main(String[] args) {
        System.out.println("====== START =======");

        LinkedList list = new LinkedList();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        Node node = reverseLinkedList3(list.root);
        System.out.println("====== END =======");
    }

    /**
     * 链表反转 1 （循环）
     *
     * @param node
     */
    static Node reverseLinkedList1(Node head) {
        Node newNode = null;
        Node curNode = head;
        while (curNode != null) {
            // 先保存 当前节点 的下一个节点
            Node temp = curNode.next;
            // 将newNode 作为 当前节点 的下一个节点
            curNode.next = newNode;
            // 重新赋值给newNode
            newNode = curNode;
            // 当前节点 改为 保存的临时节点
            curNode = temp;
        }
        return newNode;
    }

    /**
     * 链表反转 2 （栈结构 push -> pop）
     *
     * @param node
     */
    static Node reverseLinkedList2(Node node) {
        Stack<Node> stack = new Stack<>();
        Node head = null;

        // 存入栈中
        while (node != null) {
            Node temp = node.next;
            node.next = null;
            stack.push(node);
            node = temp;
        }
        if (!stack.isEmpty()) {
            head = stack.pop();
        }
        Node temp = head;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    /**
     * 递归反转法
     * @param node
     * @return
     */
    public static Node reverseLinkedList3(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newHead = reverseLinkedList3(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }



    static class Node {
        int index;
        Node next;

        Node() {}

        Node(int index) {
            this.index = index;
        }
    }
}
