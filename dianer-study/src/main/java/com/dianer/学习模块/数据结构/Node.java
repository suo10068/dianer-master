package com.dianer.学习模块.数据结构;

public class Node {
    int data;
    Node root;
    Node left;
    Node right;

    Node() {

    }

    Node(int data) {
        this.data = data;
    }

    //打印节点内容
    public void display() {
        System.out.println(" === " + data);
    }
}
