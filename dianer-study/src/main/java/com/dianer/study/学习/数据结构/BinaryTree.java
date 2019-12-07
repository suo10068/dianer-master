package com.dianer.study.学习.数据结构;

import java.util.Stack;

/**
 * 二叉树
 */
public class BinaryTree {

    //表示根节点
    private Node root;

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int[] a = new int[]{12, 2, 3, 11, 42, 73, 54, 50, 71, 90};
        for (int i = 0; i < 10; i++) {
            tree.insert(a[i]);
        }

        tree.infixOrder(tree.root);
        System.out.println();
        tree.infixOrder2(tree.root);
//        tree.preOrder(tree.root);
//        System.out.println();
//        tree.postOrder(tree.root);

    }


    //插入节点
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {//当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.data > data) {//当前值比插入值大，搜索左子节点
                    current = current.left;
                    if (current == null) {//左子节点为空，直接将新值插入到该节点
                        parentNode.left = newNode;
                        return true;
                    }
                } else {
                    current = current.right;
                    if (current == null) {//右子节点为空，直接将新值插入到该节点
                        parentNode.right = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 中序遍历
    public void infixOrder(Node root) {
        if (root != null) {
            infixOrder(root.left);
            System.out.print(root.data + " ");
            infixOrder(root.right);
        }
    }

    /**
     * 中序遍历 - 非递归
     * @param root
     */
    public void infixOrder2(Node root) {
        Stack<Node> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }


    // 前序遍历
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            infixOrder(current.left);
            infixOrder(current.right);
        }
    }

    //后序遍历
    public void postOrder(Node current) {
        if (current != null) {
            infixOrder(current.left);
            infixOrder(current.right);
            System.out.print(current.data + " ");
        }
    }

    //找到最大值
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.right;
        }
        return maxNode;
    }

    //找到最小值
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.left;
        }
        return minNode;
    }


}
