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

        A a1 = new A();
        System.out.println("Tree height = " + treeHeight.height(root1, a1) + " and diameter = " + treeHeight.diameter(root1));
        A a2 = new A();
        System.out.println("Tree height = " + treeHeight.height(root2, a2) + " and diameter = " + treeHeight.diameter(root2));


        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println("Diameter is " + diameter(root));
    }

    static Node newNode(int data)
    {
        Node node = new Node(data);
        return (node);
    }

    static class A
    {
        int ans = Integer.MIN_VALUE;
    }

    /* Function to find height of a tree */
    static int height(Node root, A a)
    {
        if (root == null)
            return 0;

        int left_height = height(root.left, a);

        int right_height = height(root.right, a);

        // update the answer, because diameter of a
        // tree is nothing but maximum value of
        // (left_height + right_height + 1) for each node
        a.ans = Math.max(a.ans, 1 + left_height +
                right_height);

        return 1 + Math.max(left_height, right_height);
    }

    static int diameter(Node root)
    {
        if (root == null)
            return 0;

        // This will store the final answer
        A a = new A();
        int height_of_tree = height(root, a);
        return a.ans;
    }

    private int height(Node root) {

        if(root == null)
            return 0;

        return (1 + Math.max(height(root.left), height(root.right)));
    }
}
