package com.personal.tryouts;

public class MirrorTree {

    public static void main(String[] args) {

        MirrorTree.Node root1 = new MirrorTree.Node(1);
        root1.left = new MirrorTree.Node(2);
        root1.right = new MirrorTree.Node(3);
        root1.left.left = new MirrorTree.Node(4);
        root1.left.right = new MirrorTree.Node(5);

        mirrorTree(root1);

        inOrder(root1);
    }

    static Node mirrorTree(Node node) {

        if(node == null)
            return null;

        Node left = mirrorTree(node.left);
        Node right = mirrorTree(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    static void inOrder(Node node)
    {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    static class Node {
        int data;
        MirrorTree.Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
}
