package com.algo_data.treesAndGraphs;

public class LinkedListOfLevels<T> {

    private LinkedListOfLevels<T> nextLevelList;                // list of dataList linked lists by level, starting at the root level
    private LinkedListOfLevels<T> previousLevelList;
    private final ListOfData<T> headDataNode;                         // stores the nodes' data in the same level

    private String label;                                       // optional label

    public LinkedListOfLevels(ListOfData<T> newDataList) {
        this.headDataNode = newDataList;
    }

    public LinkedListOfLevels(ListOfData<T> newDataList, String label){
        this.headDataNode = newDataList;

        if (!label.isEmpty()){
            this.label = label;
        }
    }

    public LinkedListOfLevels<T> appendNewLevelList(ListOfData<T> headDataNode){
        LinkedListOfLevels<T> newLevel = new LinkedListOfLevels<>(headDataNode);

        LinkedListOfLevels<T> currentLevel = this;
        while(currentLevel.nextLevelList != null){
            currentLevel = currentLevel.nextLevelList;
        }

        currentLevel.nextLevelList = newLevel;
        newLevel.previousLevelList = currentLevel;
        return newLevel;
    }

    public String getLabel() {
        return label;
    }

    public LinkedListOfLevels<T> getNextLevelList() {
        return nextLevelList;
    }

    public LinkedListOfLevels<T> getPreviousLevelList() {
        return previousLevelList;
    }

    public ListOfData<T> getHeadDataNode() {
        return headDataNode;
    }
}
