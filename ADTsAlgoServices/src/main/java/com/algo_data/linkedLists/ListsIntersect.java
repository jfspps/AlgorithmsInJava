package com.algo_data.linkedLists;

public class ListsIntersect<T> {

    private LinkedList<T> head;

    public ListsIntersect(LinkedList<T> head) {
        this.head = head;
    }

    // this is O(n + m)
    public boolean listsIntersect(LinkedList<T> list) {
        LinkedList<T> thisTail = this.head, listTail = list;

        while (thisTail.next != null) {
            thisTail = thisTail.next;
        }

        while (listTail.next != null) {
            listTail = listTail.next;
        }

        if (thisTail == listTail) {
            System.out.println("Given lists intersect");
            return true;
        } else {
            System.out.println("Given lists do not intersect");
            return false;
        }
    }

    // overall O(n + m)
    public LinkedList<T> getIntersection(LinkedList<T> list) {
        if (!this.listsIntersect(list)) {
            return null;
        }

        int difference = 0;
        LinkedList<T> longestList;
        LinkedList<T> shortestList;

        if (this.head.length() > list.length()) {
            difference = this.head.length() - list.length();
            longestList = this.head;
            shortestList = list;
        } else {
            difference = list.length() - this.head.length();
            longestList = list;
            shortestList = this.head;
        }

        // visualise two intersecting lists such that the tail of both lists are identical, in the shape of 'Y'
        // if lists are of equal length then move references in both lists at the same time
        // if lists are of unequal length then advance by the difference in the longer list and then at the same time

        if (difference == 0) {
            while (this.head != list) {
                this.head = this.head.next;
                list = list.next;
            }
            return this.head;
        }

        while (difference > 0) {
            longestList = longestList.next;
            difference--;
        }
        while (longestList != shortestList) {
            longestList = longestList.next;
            shortestList = shortestList.next;
        }
        return longestList;
    }
}
