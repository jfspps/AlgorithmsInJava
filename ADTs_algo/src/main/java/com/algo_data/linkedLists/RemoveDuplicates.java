package com.algo_data.linkedLists;

public class RemoveDuplicates<T> {

    LinkedList<Integer> linkedList;

    public RemoveDuplicates(LinkedList<Integer> list) {
        linkedList = list;
    }

    // with tally buffer (assume only integers between 0 and 1000 are applied)
    // time complexity is O(n)
    public void removeDuplicatesWithTally(){
        int[] tally = new int[1000];

        LinkedList<Integer> currentNode = this.linkedList;
        tally[this.linkedList.getData()]++;
        int count = 0;

        while(currentNode.next != null){
            if (tally[currentNode.next.getData()] == 0){
                tally[currentNode.next.getData()]++;
                currentNode = currentNode.next;
            } else {
                //delete currentNode and move on
                currentNode.next = currentNode.next.next;
                count++;
            }
        }

        System.out.println(count + " duplicates removed");
    }

    // without tally buffer; using two pointers
    // time complexity is O(n^2)
    public void removeDuplicatesWithoutTally(){
        LinkedList<Integer> currentNode = this.linkedList;
        LinkedList<Integer> leadPointer = currentNode;
        int count = 0;

        while (currentNode.next != null){
            while (leadPointer.next != null) {
                if (!leadPointer.next.getData().equals(currentNode.getData())){
                    leadPointer = leadPointer.next;
                } else {
                    leadPointer.next = leadPointer.next.next;
                    count++;
                }
            }
            currentNode = currentNode.next;
            leadPointer = currentNode;
        }

        System.out.println(count + " duplicates removed");
    }
}
