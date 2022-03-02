package com.personal.tryouts;

public class TreeHeight {

    static class Node {
        int data;
        TreeHeight.Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        TreeHeight treeHeight = new TreeHeight();

        TreeHeight.Node root1 = new TreeHeight.Node(1);
        root1.left = new TreeHeight.Node(2);
        root1.right = new TreeHeight.Node(3);
        root1.left.left = new TreeHeight.Node(4);
        root1.left.right = new TreeHeight.Node(5);

        TreeHeight.Node root2 = new TreeHeight.Node(1);
        root2.left = new TreeHeight.Node(2);
        root2.right = new TreeHeight.Node(3);
        root2.left.left = new TreeHeight.Node(4);
        root2.left.right = new TreeHeight.Node(5);
        root2.left.left.right = new TreeHeight.Node(6);

        System.out.println(treeHeight.height(root1));
        System.out.println(treeHeight.height(root2));

    }

    private int height(Node root) {

        if(root == null)
            return 0;

        return (1 + Math.max(height(root.left), height(root.right)));
    }
}
