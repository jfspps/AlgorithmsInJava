package com.algo_data.linkedLists;

public class FindKthToLast<T> {

    private final LinkedList<T> list;

    public FindKthToLast(LinkedList<T> list) {
        this.list = list;
    }

    // find the Kth to last element of a singly linked list
    // time complexity is O(n)
    public LinkedList<T> findKthToLast(int k){
        if (list == null){
            System.out.println("List is empty");
            return null;
        }

        // length is decremented later
        int length = list.length();

        if (k > length){
            System.out.println("Kth parameter is larger than the list length");
            return null;
        }

        int nodeIndex = 0;
        LinkedList<T> currentNode = list;
        // k decreases from length to 1 as list traversed from head node
        // start from the beginning, increment nodeIndex = 0 until (nodeIndex = length - k)
        while (nodeIndex < length - k && currentNode.next != null){
            currentNode = currentNode.next;
            nodeIndex++;
        }

        return currentNode;
    }
}
