package com.leetcode;

import java.util.Queue;

public class MinmumDepthBinaryTree {

    Node root;

    // Constructors
    MinmumDepthBinaryTree(int key) {
        root = new Node(key);
    }

    MinmumDepthBinaryTree() {
        root = null;
    }

    public static int minDepth(MinmumDepthBinaryTree root) {
        Queue<Node> queue = new java.util.LinkedList<Node>();
        int depth = 0;

        if (root != null) {
            queue.add(root.root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                depth++;
                for (int i = 0; i < size; i++) {
                    Node n = queue.remove();
                    if (n.left == null && n.right == null) return depth;
                    if (n.left != null) queue.add(n.left);
                    if (n.right != null) queue.add(n.right);
                }

            }
        }
        return depth;
    }



    public static void main(String[] args) {
        MinmumDepthBinaryTree tree = new MinmumDepthBinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);
        minDepth(tree);
    }

}

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}