package com.algo_data.treesAndGraphs;

import com.algo_data.stacksAndQueues.Queue;

import java.util.LinkedList;

public class BinaryTree<T> {

    private final T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;
    private BinaryTree<T> parent;
    private boolean visited;

    public BinaryTree(T data) {
        this.data = data;
        this.visited = false;
    }

    public void setLeftChild(BinaryTree<T> leftChild) {
        if (leftChild != null){
            this.leftChild = leftChild;
            leftChild.parent = this;
        }
    }

    public void setRightChild(BinaryTree<T> rightChild) {
        if (rightChild != null){
            this.rightChild = rightChild;
            rightChild.parent = this;
        }
    }

    public void inOrderTraversal(BinaryTree<T> tree) {
        // reach the bottom of the tree and return the leftChild, then the node, then the right child
        if (tree != null) {
            inOrderTraversal(tree.leftChild);
            printNode(tree);
            inOrderTraversal(tree.rightChild);
        }
    }

    public void setChildren(BinaryTree<T> lChild, BinaryTree<T> rChild) {
        if (lChild != null){
            this.leftChild = lChild;
            lChild.parent = this;
        }
        if (rChild != null){
            this.rightChild = rChild;
            rChild.parent = this;
        }
    }

    public void preOrderTraversal(BinaryTree<T> tree) {
        // process current node then visit the child nodes, left-to-right
        if (tree != null) {
            printNode(tree);
            preOrderTraversal(tree.leftChild);
            preOrderTraversal(tree.rightChild);
        }
    }

    public void postOrderTraversal(BinaryTree<T> tree) {
        // process the child nodes first, left-to-right and then process the given node
        if (tree != null) {
            postOrderTraversal(tree.leftChild);
            postOrderTraversal(tree.rightChild);
            printNode(tree);
        }
    }

    public void levelOrderTraversal(BinaryTree<T> root){
        Queue<BinaryTree<T>> queue = new Queue<>();
        printNode(root);
        queue.enqueue(root);

        while (!queue.isEmpty()){
            root = queue.dequeue();

            if (root.getLeftChild() != null){
                printNode(root.leftChild);
                queue.enqueue(root.getLeftChild());
            }

            if (root.getRightChild() != null){
                printNode(root.rightChild);
                queue.enqueue(root.getRightChild());
            }
        }
    }

    public void levelOrderReversedTraversal(BinaryTree<T> root){
        Queue<BinaryTree<T>> queue = new Queue<>();
        printNode(root);
        queue.enqueue(root);

        while (!queue.isEmpty()){
            root = queue.dequeue();

            if (root.getRightChild() != null){
                printNode(root.rightChild);
                queue.enqueue(root.getRightChild());
            }

            if (root.getLeftChild() != null){
                printNode(root.leftChild);
                queue.enqueue(root.getLeftChild());
            }
        }
    }

    public void printNode(BinaryTree<T> node) {
        // do something with data (can be overridden if required)
        System.out.print(node.data + " ");
    }

    public T getData() {
        return this.data;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }


    public BinaryTree<T> getParent(){
        return this.parent;
    }

    public int getMaxDepth(BinaryTree<T> tree) {
        int leftBranch;
        int rightBranch;

        if (tree != null){
            leftBranch = getMaxDepth(tree.leftChild);
            rightBranch = getMaxDepth(tree.rightChild);

            if (leftBranch > rightBranch){
                return leftBranch + 1;
            } else {
                return rightBranch + 1;
            }
        }
        return 0;
    }

    public int getShortestDepth(BinaryTree<T> tree){
        int leftBranch;
        int rightBranch;

        if (tree != null){
            leftBranch = getMaxDepth(tree.leftChild);
            rightBranch = getMaxDepth(tree.rightChild);

            if (leftBranch < rightBranch){
                return leftBranch + 1;
            } else {
                return rightBranch + 1;
            }
        }
        return 0;
    }

    // while not abstract binary trees, a binary search tree must handle comparable data types, in this case integers
    // and is included here instead of the class, BinarySearchTree, which always builds BSTs

    public boolean isABinarySearchTree(BinaryTree<Integer> tree, LinkedList<Integer> list) {
        if (tree != null) {
            isABinarySearchTree(tree.leftChild, list);
            list.add(tree.data);
            isABinarySearchTree(tree.rightChild, list);
        }
        return checkIfBST(list);
    }

    // this checks the sequence of nodes from an in-order traversal
    private boolean checkIfBST(LinkedList<Integer> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < size - 1; i++){
            if (linkedList.get(i) > linkedList.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
