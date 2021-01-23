package com.algo_data.linkedLists;

public class ListIsAPalindrome {

    private LinkedList<Character> head;

    public ListIsAPalindrome(LinkedList<Character> head) {
        this.head = head;
    }

    // time complexity is O(n)
    // checks if the list is a palindrome, as { x, y, z, z, y, x } or { x, y, z, y, x }
    public boolean isAPalindrome(){
        LinkedList<Character> halfwayMark = head, fast = head;
        int length = this.head.length();

        // this part is O(n/2) or O(n)
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            halfwayMark = halfwayMark.next;
        }

        ReverseList<Character> reverseList = new ReverseList<>(this.head);
        LinkedList<Character> reversedLeftHalf;

        // if the list is odd in length, partition first then advance halfwayMark; otherwise advance halfwayMark then partition
        if (length%2 != 0){
            reversedLeftHalf = reverseList.reverseListUpToK(halfwayMark);
            halfwayMark = halfwayMark.next;
        } else {
            halfwayMark = halfwayMark.next;
            reversedLeftHalf = reverseList.reverseListUpToK(halfwayMark);
        }

        // this final part is O(n/2) or O(n)
        while (halfwayMark != null){
            if (reversedLeftHalf.getData() != halfwayMark.getData()){
                System.out.println("Given list is not a palindrome");
                return false;
            }
            halfwayMark = halfwayMark.next;
            reversedLeftHalf = reversedLeftHalf.next;
        }

        System.out.println("Given list is a palindrome");
        return true;
    }
}
