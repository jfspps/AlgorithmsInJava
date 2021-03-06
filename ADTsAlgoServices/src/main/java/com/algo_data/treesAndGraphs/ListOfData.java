package com.algo_data.treesAndGraphs;

public class ListOfData<T> {

    private ListOfData<T> next;
    private ListOfData<T> previous;
    private final T data;

    public ListOfData(T data) {
        this.data = data;
    }

    public ListOfData<T> appendDataList(T data){
        ListOfData<T> currentNode = this;

        if (data != null){
            //get to the end
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }

            ListOfData<T> newDataNode = new ListOfData<>(data);
            newDataNode.previous = currentNode;
            currentNode.next = newDataNode;
        }
        return this.next;
    }

    public T getData() {
        return data;
    }

    public void printDataList(){
        System.out.print("In this list: ");
        System.out.print(this.data + " ");
        ListOfData<T> currentNode = this;

        while (currentNode.next != null){
            System.out.print(currentNode.next.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public ListOfData<T> goToEndOfList(){
        ListOfData<T> currentNode = this;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}
