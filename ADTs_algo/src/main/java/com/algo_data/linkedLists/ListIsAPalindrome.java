package com.algo_data.linkedLists;

public class ListIsAPalindrome {

    private LinkedList<Character> head;

    public ListIsAPalindrome(LinkedList<Character> head) {
        this.head = head;
    }

    // time complexity is O(n)
    public boolean isAPalindrome(int length){
        LinkedList<Character> slow = head, fast = head;

        // this part is O(n/2) or O(n)
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ReverseList<Character> reverseList = new ReverseList<>(this.head);
        LinkedList<Character> reversedLeftHalf;

        // if the list is odd in length, partition first then advance slow; otherwise advance slow then partition
        if (length%2 != 0){
            reversedLeftHalf = reverseList.reverseListUpToK(slow);
            slow = slow.next;
        } else {
            slow = slow.next;
            reversedLeftHalf = reverseList.reverseListUpToK(slow);
        }

        // this final part is O(n/2) or O(n)
        while (slow != null){
            if (reversedLeftHalf.getData() != slow.getData()){
                System.out.println("Given list is not a palindrome");
                return false;
            }
            slow = slow.next;
            reversedLeftHalf = reversedLeftHalf.next;
        }

        System.out.println("Given list is a palindrome");
        return true;
    }
}
