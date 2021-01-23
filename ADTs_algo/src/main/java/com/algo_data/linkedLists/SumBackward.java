package com.algo_data.linkedLists;

public class SumBackward {

    LinkedList<Integer> head;

    public SumBackward(LinkedList<Integer> list) {
        this.head = list;
    }

    // time complexity is a series of O(n/2) or just O(n)
    public LinkedList<Integer> sumReversed(){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List contains only one node");
            return head;
        }

        // set the two pointers and establish the linked list length
        // this part is O(n/2)
        LinkedList<Integer> slower = head;
        LinkedList<Integer> faster = head;
        int nodeCount = 1;

        while(faster.next != null && faster.next.next != null){
            faster = faster.next.next;
            slower = slower.next;
            nodeCount++;
        }
        System.out.println("Max. no. of digits per operand: " + nodeCount);

        // the list is of even length then advance slower one more place
        if (nodeCount%2 == 0){
            slower = slower.next;
        }

        head.printLeftPartition(slower);
        head.printRightPartition(slower);

        // place 'faster' back to the beginning ('slower' will be halfway along the list)
        faster = head;
        LinkedList<Integer> halfway = slower;      // set a marker
        int multiplier = 1;
        int sum = 0;

        // process each digit until faster is halfway along the list
        // building the sum is O(n/2)
        while (faster != halfway){
            sum += (faster.getData() + slower.getData()) * multiplier;
            multiplier *= 10;
            faster = faster.next;
            slower = slower.next;
        }

        // for odd-sized 'head' lists, the left-hand operand, marked by 'faster' is one digit shorter than the right-hand operand
        if (slower != null){
            sum += slower.getData() * multiplier;
        }

        return printIntToList_reverse(sum);
    }

    // overall printing is O(n/2)
    public LinkedList<Integer> printIntToList_reverse(int sum) {
        // print sum in a linked list in reverse
        int divisor = 10;
        LinkedList<Integer> sumList = new LinkedList<>(sum % divisor);
        sum /= 10;

        // add remaining digits
        while (sum > 0){
            sumList.append(sum % 10);
            sum /= 10;
        }
        return sumList;
    }
}
