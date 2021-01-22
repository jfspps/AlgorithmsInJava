package com.algo_data.linkedLists;

public class PartitionAtNodeP {

    LinkedList<Integer> head;

    public PartitionAtNodeP(LinkedList<Integer> list) {
        this.head = list;
    }

    // partition a list about a data value p (note a node need not exist with value p)
    // time complexity is O(2n) or just O(n)
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

        // move consecutive nodes starting from head which are >= p; while loop stops when first node < p is reached
        // update head as nodes are re-linked on shuffling; this part is at worst O(n)
        while (head.getData() >= p){
            tail.next = head;
            head = head.next;
            tail.next.next = null;
            tail = tail.next;
        }
        LinkedList<Integer> afterNewHead = head;

        // head established; continue the above while loop until originalTail node is processed
        while (afterNewHead != originalTail){
            if (afterNewHead.next.getData() >= p){
                // update links such that the node is linked to the tail
                tail.next = afterNewHead.next;
                afterNewHead.next = afterNewHead.next.next;
                tail.next.next = null;
                tail = tail.next;
            }

            // when original.data >= p, then afterNewHead != null is always true
            if (originalTail.next == null) {
                break;
            }

            afterNewHead = afterNewHead.next;
        }
        return head;
    }
}
