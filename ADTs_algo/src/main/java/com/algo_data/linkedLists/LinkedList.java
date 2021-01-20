package com.algo_data.linkedLists;

// implementation of a singly linked-list (without loops)
public class LinkedList<T> {
    LinkedList<T> next = null;
    T data;

    public LinkedList(T data) {
        this.data = data;
    }

    public int length(){
        if (this.next == null){
            return 1;
        }
        int count = 1;
        LinkedList<T> linkedList = this;

        while (linkedList.next != null){
            count++;
            linkedList = linkedList.next;
        }
        return count;
    }

    public T getData() {
        return data;
    }

    // getNode returns the first instance of LinkedList with given data; can also be used to check if data is present
    public LinkedList<T> getNode(T data){
        if (this.data == data){
            return this;
        }
        LinkedList<T> currentNode = this;
        while (currentNode.next != null){
            if (currentNode.next.data == data){
                return currentNode.next;
            }
            currentNode = currentNode.next;
        }
        System.out.println("Data not found");
        return null;
    }

    // time complexity is O(n)
    public boolean nodeIsPresent(LinkedList<T> node){
        if (this == node){
            return true;
        }
        LinkedList<T> currentNode = this;
        while (currentNode.next != null){
            if (currentNode.next == node){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // adds to an array of LinkedLists, from index i, which have the value data
    public void getNodeList(T data, LinkedList<T>[] array, int i){
        LinkedList<T> currentNode = this;

        if (this.data == data){
            array[i] = currentNode;
            i++;
        }

        while (currentNode.next != null){
            if (currentNode.next.data == data){
                array[i] = currentNode;
                i++;
            }
            currentNode = currentNode.next;
        }
        System.out.println("Added " + i + " nodes");
    }

    // -----append methods: for list of n nodes, this will require 1 + 2 + ... + n calls to append, i.e. O(n^2)--------
    // LinkedList objects cannot be null, however, LinkedList data can be null

    public void append(T data){
        LinkedList<T> newEnd = new LinkedList<>(data);      // new Node referenced by newEnd
        LinkedList<T> thisLinkedList = this;                // grab head node

        // traverse list and append to the tail
        while (thisLinkedList.next != null){
            thisLinkedList = thisLinkedList.next;
        }
        thisLinkedList.next = newEnd;
    }

    public void append(LinkedList<T> next){
        if (next == null){
            System.out.println("Cannot append null node");
            return;
        }
        LinkedList<T> thisLinkedList = this;           // grab this Node

        // traverse list and append to the tail
        while (thisLinkedList.next != null){
            thisLinkedList = thisLinkedList.next;
        }
        thisLinkedList.next = next;
    }

    // -------insert methods: -----------------------------------------------------------------------------------------

    // inserts after the first occurrence of precedingData;
    // returns a reference to inserted node if inserted and null if not
    // getNode() is O(n), thus insert() is also O(n)
    public LinkedList<T> insert(T precedingData, T data){
        LinkedList<T> precedingNode = getNode(precedingData);

        // check data is somewhere in the list
        if (precedingNode == null){
            return null;
        }

        LinkedList<T> newNode = new LinkedList<>(data);
        newNode.next = precedingNode.next.next;
        precedingNode.next = newNode;
        return newNode;
    }

    // inserts after the given node; nodeIsPresent() is O(n) so insert() is also O(n)
    public LinkedList<T> insert(LinkedList<T> precedingNode, T data){
        if (precedingNode == null){
            System.out.println("Cannot insert a null node");
            return null;
        }

        if (!this.nodeIsPresent(precedingNode)) {
            System.out.println("Node not part of this list");
            return null;
        }

        LinkedList<T> proceedingNode = precedingNode.next;
        LinkedList<T> newNode = new LinkedList<>(data);
        precedingNode.next = newNode;
        newNode.next = proceedingNode;
        return newNode;
    }

    // -----delete methods: updates the next property; garbage collection will clear up heap;--------------------------
    // returns a reference to the second node if the head is deleted, and returns head otherwise;
    // time complexity is O(n)

    public LinkedList<T> deleteData(T nodeData){
        LinkedList<T> currentLinkedList = this;

        // if head holds requisite data, return head.next
        if (currentLinkedList.data == nodeData){
            LinkedList<T> secondNode = currentLinkedList.next;
            currentLinkedList.next = null;
            return secondNode;   // could be null
        }

        // still at head; traverse Node until data found
        while (currentLinkedList.next != null){
            if (currentLinkedList.next.data == nodeData){
                currentLinkedList.next = currentLinkedList.next.next;
                return this;
            }
            currentLinkedList = currentLinkedList.next;
        }

        System.out.println("Data not found; nothing deleted");
        return this;
    }

    public LinkedList<T> deleteNode(LinkedList<T> linkedList){
        if (this == linkedList){
            LinkedList<T> secondNode = this.next;
            this.next = null;
            return secondNode;   // could be null
        }

        LinkedList<T> currentLinkedList = this;

        while (currentLinkedList.next != null){
            if (currentLinkedList.next == linkedList){
                currentLinkedList.next = currentLinkedList.next.next;
                System.out.println("Node with value " + linkedList.data + " deleted");
                return this;
            } else {
                currentLinkedList = currentLinkedList.next;
            }
        }

        System.out.println("Node not found; nothing deleted");
        return this;
    }

    // -----print methods: attempts to print a String of data---------------------------------------------------------
    // time complexity depends on the number of nodes to process; printing lists is O(n), printing nodes is O(1)

    public String printLinkedList(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Head node: ").append(this.data).append(", ");

        if (this.next == null){
            return stringBuilder.toString();
        }

        int count = 1;
        LinkedList<T> currentLinkedList = this.next;
        while (currentLinkedList.next != null){
            stringBuilder.append("node ").append(count).append(": ").append(currentLinkedList.data).append(", ");
            currentLinkedList = currentLinkedList.next;
        }
        stringBuilder.append("tail node: ").append(currentLinkedList.data);
        return stringBuilder.toString();
    }

    public String printNodeData(LinkedList<T> linkedList){
        return String.valueOf(linkedList.data);
    }

    public String printRightPartition(LinkedList<T> k) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Right-hand partition is: ");

        while (k.next !=null){
            stringBuilder.append(k.data).append(" ");
            k = k.next;
        }
        return stringBuilder.toString();
    }

    public String printLeftPartition(LinkedList<T> k){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Left-hand partition is: ");

        LinkedList<T> linkedList = this;
        while (linkedList.next != null && linkedList.next != k){
            stringBuilder.append(k.data).append(" ");
            linkedList = linkedList.next;
        }
        return stringBuilder.toString();
    }
}
