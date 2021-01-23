package com.algo_data.linkedLists;

public class ReverseList<T> {

    private LinkedList<T> head;

    public ReverseList(LinkedList<T> list) {
        this.head = list;
    }

    /**
     * Reverses a list and returns the reversed list. Returns null if list is empty.
     * */
    public LinkedList<T> reverseList(){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List contains one node");
            return head;
        }

        // swap nodes in a list comprised to just two nodes
        if (head.next.next == null){
            head.next.next = head;
            LinkedList<T> newHead = head.next;
            head.next = null;
            return newHead;
        }

        // for lists with at least three nodes
        LinkedList<T> first = head;
        LinkedList<T> second = head.next;
        LinkedList<T> third = head.next.next;

        first.next = null;
        second.next = first;
        first = third;
        third = first.next;

        while(first.next != null){
            first.next = second;
            second = first;
            first = third;
            third = first.next;
        }
        first.next = second;
        return first;
    }

    /**
     * Starting from head, reverse up to but excluding Node K. Returns a new, separated LinkedList with nodes reversed,
     *  if appropriate and null if nothing to reverse
     * */
    public LinkedList<T> reverseListUpToK(LinkedList<T> K){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List contains one node");
            return null;
        }

        // handle when K is near the beginning of the list
        if (K == head){
            System.out.println("Kth element is head node, nothing to reverse");
            return null;
        }

        if (K == head.next){
            System.out.println("Kth element is 2nd in the list");
            head.next = null;
            return head;
        }

        if (K == head.next.next){
            System.out.println("Kth element is 3rd in the list");
            LinkedList<T> q = head.next;
            q.next = head;
            head.next = null;
            return q;
        }

        // for lists with at least three nodes
        LinkedList<T> first = head;
        LinkedList<T> second = head.next;
        LinkedList<T> third = head.next.next;

        first.next = null;
        second.next = first;
        first = third;
        third = first.next;

        while(third != null && first.next != K){
            first.next = second;
            second = first;
            first = third;
            third = first.next;
        }
        first.next = second;
        return first;
    }
}
