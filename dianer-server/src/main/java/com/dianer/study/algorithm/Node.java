package com.dianer.study.algorithm;

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
