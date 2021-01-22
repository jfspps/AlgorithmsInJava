package com.algo_data.linkedLists;

public class PartitionAtNodeP {

    LinkedList<Integer> head;

    public PartitionAtNodeP(LinkedList<Integer> list) {
        this.head = list;
    }

    // partition a list about a data value p (note a node need not exist with value p)
    // time complexity is O(n)
    public LinkedList<Integer> partition(int p){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List only contains one node");
            return head;
        }

        //get to the tail Node
        LinkedList<Integer> tail = head;
        while (tail.next != null){
            tail = tail.next;
        }

        // record the original tail node reference
        LinkedList<Integer> originalTail = tail;

        // 1. Establish the head node by shuffling the beginning nodes until node.data < p
        // this part is at worst O(n)
        while (head.getData() >= p){
            tail.next = head;
            head = head.next;
            tail.next.next = null;
            tail = tail.next;
        }
        LinkedList<Integer> afterNewHead = head;

        // 2. Process the remaining nodes up to and including the original tail node
        while (afterNewHead != originalTail){
            if (afterNewHead.next.getData() >= p){
                // update links such that the node is linked to the tail
                tail.next = afterNewHead.next;
                afterNewHead.next = afterNewHead.next.next;
                tail.next.next = null;
                tail = tail.next;
            }

            // in cases when originalTail.data >= p, then afterNewHead != null is always true so this check exits the loop
            if (originalTail.next == null) {
                break;
            }

            afterNewHead = afterNewHead.next;
        }
        return head;
    }
}
