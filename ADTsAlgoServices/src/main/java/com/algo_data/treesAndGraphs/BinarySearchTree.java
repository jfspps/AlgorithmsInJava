package com.algo_data.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree extends BinaryTree<Integer> {

    // data can be null, though all initialised nodes cannot
    public BinarySearchTree(Integer data) {
        super(data);
    }

    public BinarySearchTree buildBinarySearchTree(Integer[] sortedArray) {
        if (sortedArray.length == 1){
            return new BinarySearchTree(sortedArray[0]);
        }

        if (sortedArray.length > 1) {
            int length = sortedArray.length;
            BinarySearchTree parent = new BinarySearchTree(sortedArray[length / 2]);

            Integer[] left = new Integer[length / 2];
            for (int i = 0; i < length / 2; i++) {
                left[i] = sortedArray[i];
            }

            Integer[] right;
            if (length % 2 == 0) {
                // right-hand will be one element smaller than the left
                right = new Integer[(length / 2) - 1];
                for (int j = 0; j < (length / 2) - 1; j++) {
                    right[j] = sortedArray[j + (length / 2) + 1];
                }
            } else {
                // left- and right-hand arrays would be of equal length
                right = new Integer[(length / 2)];
                for (int j = 0; j < (length / 2); j++) {
                    right[j] = sortedArray[j + (length / 2) + 1];
                }
            }

            parent.setChildren(buildBinarySearchTree(left), buildBinarySearchTree(right));
            return parent;
        } else
            return null;
    }

    /**
     * build a linked list of each level: note that level must be 0 on initial call (updated in the method)
     * level is zero-based to coincide with ArrayList and signifies which level is being processed
     * time complexity is O(n), where n = number of nodes + null nodes
     */
    public ArrayList<LinkedList<BinaryTree<Integer>>> buildLevelLinkedList(
            BinaryTree<Integer> node, ArrayList<LinkedList<BinaryTree<Integer>>> levelList, int level){
        if (node == null){
            return null;
        }

        // dataList stores the node; levelList stores a collection of dataLists for a given level
        // note that levelList is stored externally of the first call of createLevelLinkedList

        LinkedList<BinaryTree<Integer>> dataList;
        // **initially, size() is 0 and level is 0 meaning this level has not been visited before;
        if (levelList.size() == level){
            dataList = new LinkedList<>();
            levelList.add(dataList);
        } else {
            // for the right-child, levelList.size > level
            // levelList.size != level so instead dataList will get the list of nodes which already contains left-child
            dataList = levelList.get(level);
        }

        dataList.add(node);
        buildLevelLinkedList(node.getLeftChild(), levelList, level + 1);
        buildLevelLinkedList(node.getRightChild(), levelList, level + 1);
        return levelList;
    }

    /**
     * Returns a node with the given Integer
     * @param parent root node
     * @param data Integer sought after
     * @return node with given Integer or null if nothing found
     */
    public BinarySearchTree getNode(BinarySearchTree parent, Integer data){
        if (parent == null){
            return null;
        }

        if (parent.getData().equals(data)){
            return parent;
        }

        if (data < parent.getData()){
            return getNode((BinarySearchTree) parent.getLeftChild(), data);
        } else
            return getNode((BinarySearchTree) parent.getRightChild(), data);
    }

    /**
     * Returns the next node from an in-order traversal following the given node
     * @param node starting node
     * @return returns the next node following in-order traversal and null if there is none
     */
    public BinarySearchTree getNextInOrder(BinarySearchTree node) {
        // if a parent with a right-child
        if (node.getRightChild() != null) {
            BinarySearchTree tree = (BinarySearchTree) node.getRightChild();
            while (tree.getLeftChild() != null) {
                tree = (BinarySearchTree) tree.getLeftChild();
            }
            return tree;
        } else if (node.getParent() != null) {
            // leaf nodes next...
            BinarySearchTree parent = (BinarySearchTree) node.getParent();

            // if at right-child leaf
            if (parent.getRightChild() == node && parent.getParent() != null) {
                // check if parent is left child of grandparent
                if (parent.getParent().getLeftChild() == parent){
                    return (BinarySearchTree) parent.getParent();
                } else {
                    // currently on rightmost subtree
                    return null;
                }
            }

            // if a left-child leaf
            if (parent.getLeftChild() == node) {
                return parent;
            }
        }
        return null;
    }
}
