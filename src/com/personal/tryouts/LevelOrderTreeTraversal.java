package com.personal.tryouts;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LevelOrderTreeTraversal {

    // A Binary Tree Node
    static class Node {
        int data;
        Node left, right;
        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        // function to print Right view of
        // binary tree
        void getViewByType(Node root, String viewType)
        {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {

                // get number of nodes for each level
                int n = q.size();

                // traverse all the nodes of the current level
                for (int i = 0; i < n; i++) {
                    Node curr = q.peek();
                    q.remove();

                    // print the last node of each level
                    if(Objects.equals(viewType, "LEFT")) {
                        if (i == 0) {
                            System.out.print(curr.data);
                            System.out.print(" ");
                        }
                    } else {
                        if (i == n - 1) {
                            System.out.print(curr.data);
                            System.out.print(" ");
                        }
                    }


                    // if left child is not null add it into
                    // the
                    // queue
                    if (curr.left != null) {
                        q.add(curr.left);
                    }

                    // if right child is not null add it into
                    // the
                    // queue
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        // Driver code
        public static void main(String[] args)
        {

            // Let's construct the tree as
            // shown in example
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(6);
            tree.root.right.right = new Node(7);
            tree.root.right.left.right = new Node(8);


            System.out.println("Right View is Below :");
            tree.getViewByType(tree.root, "RIGHT");
            System.out.println();
            System.out.println("Left View is Below :");
            tree.getViewByType(tree.root, "LEFT");


            int levelOfNode = tree.getLevelOfANode(tree.root, 2);
            System.out.println("Levels = "+ levelOfNode);
        }

        /**
         * this is wrong, yet to correct it
         * @param root
         * @param key
         * @return
         */
        private int getLevelOfANode(Node root, int key) {

            int level = 0;
            if(root == null){
                return 0;
            }
            Queue<Node> q = new LinkedList();
            q.add(root);
            while(!q.isEmpty()){
                level++;
                for(int i=0; i<q.size(); i++) {
                    Node n = q.peek();
                    q.remove();
                    if(n.data == key) {
                        return level;
                    } else if(n.left != null){
                        q.add(n.left);
                    } else if(n.right != null){
                        q.add(n.right);
                    }
                }
            }

            return level;
        }
    }
}



