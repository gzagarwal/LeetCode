package com.leetcode;

import java.util.*;

public class AverageBinaryLevel {

    Node root;

    // Constructors
    AverageBinaryLevel(int key)
    {
        root = new Node(key);
    }

    AverageBinaryLevel()
    {
        root = null;
    }
    public static void main(String[] args) {
        AverageBinaryLevel tree = new AverageBinaryLevel();
        tree.root=new Node(2147483647);
        tree.root.left=new Node(2147483647);
        tree.root.right=new Node(2147483647);
         average(tree);
    }

    private static void average(AverageBinaryLevel root) {
        List<Double> average = new ArrayList();

        Queue<Node> queue = new LinkedList();

        queue.add(root.root);
        average.add((double)root.root.key);
        while(!queue.isEmpty()){

            List<Integer> tempAverage = new ArrayList();
            int qSize = queue.size();

            for(int k=0;k<qSize;k++){
                Node node = queue.peek();
                queue.remove(node);
                if(node.left!=null){
                    tempAverage.add(node.left.key);
                    queue.add(node.left);
                }
                if(node.right!=null){
                    tempAverage.add(node.right.key);
                    queue.add(node.right);
                }
            }

            int size = tempAverage.size();
            long temp =0;
            for(int k :tempAverage){
                temp=temp+k;
            }
            if(size>0) {
                double averag = (double)temp / size;
                average.add(averag);
            }

        }
        System.out.println(average);


    }


}


class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}