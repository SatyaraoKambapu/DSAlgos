package com.personal.tryouts;

public class TreeIdenticalCheck {

    public static void main(String[] args) {

        TreeIdenticalCheck checkIdentical = new TreeIdenticalCheck();

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(checkIdentical.checkIdentical(root1, root2));

    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private boolean checkIdentical(Node node1, Node node2) {

        if(node1 == null && node2 == null)
            return true;

        if(node1 != null && node2 != null) {
            return node1.data == node2.data && checkIdentical(node1.left, node2.left) && checkIdentical(node1.right, node2.right);
        }

        return false;

    }
}
