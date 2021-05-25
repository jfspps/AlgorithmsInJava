package com.algo_data.treesAndGraphs;

import com.algo_data.stacksAndQueues.Queue;

public class SearchableTree<T> {

    private final T data;
    private boolean visited;

    // this applied to a more generic graph as opposed to a binary tree
    private SearchableTree<T>[] adjacent;

    public SearchableTree(T data) {
        this.visited = false;
        this.data = data;
    }

    public SearchableTree<T>[] getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(SearchableTree<T>[] adjacent) {
        this.adjacent = adjacent;
    }

    public boolean hasBeenVisited() {
        return this.visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    // can be reviewed as required
    public void printData(SearchableTree<T> node) {
        System.out.println(node.data);
    }

    // traverses a tree following a depth-based approach (visit child nodes before peers)
    // like BFS, DFS is O(n)
    public String depthFirstSearch(SearchableTree<T> root, StringBuilder stringBuilder) {
        if (root == null) {
            System.out.println("Given node is null");
            return "Null graph received";
        }

        // in considering recursion, the newly found node is printed before visiting it's child nodes (hence pre-order)
        stringBuilder.append(root.data).append(" ");
        root.visited = true;

        for (SearchableTree<T> tree : root.adjacent) {
            //we must check if visited otherwise for cyclic graphs one would end up in an infinite loop
            if (!tree.visited) {
                depthFirstSearch(tree, stringBuilder);
            }
        }

        return stringBuilder.toString();
    }

    // build a queue of neighbouring nodes using rootsNeighbours and visit them once all are queued
    // like DFS, BFS is O(n)
    public String breadthFirstSearch(SearchableTree<T> root, StringBuilder stringBuilder) {
        if (root == null) {
            System.out.println("Given node is null");
            return "Null graph received";
        }

        Queue queuedNodes = new Queue();
        root.visited = true;
        queuedNodes.enqueue(root);    // FIFO, root handled first

        while (!queuedNodes.isEmpty()) {
            // initially, this returns root and then adds its siblings to the queue
            // the for loop should not repeat itself for each sibling since the flag node.visited is true
            SearchableTree<T> currentNode = (SearchableTree<T>) queuedNodes.dequeue();
            stringBuilder.append(currentNode.data).append(" ");

            // we must check if visited otherwise for cyclic graphs one would end up in an infinite loop
            for (SearchableTree<T> node : currentNode.getAdjacent()) {
                if (!node.visited) {
                    node.visited = true;
                    queuedNodes.enqueue(node);
                }
            }
        }

        return stringBuilder.toString();
    }

    // modified breadthFirstSearch(), check the node and its siblings to see if they have been visited elsewhere
    public boolean hasBeenVisitedByOthers(SearchableTree<T> root, SearchableTree<T>[] rootsNeighbours) {
        System.out.println("Processing " + root.data + "...");

        if (root.visited) {
            System.out.println("Someone's been at " + root.data + " before; pathway present");
            return true;
        }

        Queue neighbouringNodes = new Queue();
        root.visited = true;
        neighbouringNodes.enqueue(root);

        while (rootsNeighbours != null && !neighbouringNodes.isEmpty()) {
            SearchableTree<T> currentNode = (SearchableTree<T>) neighbouringNodes.dequeue();
            printData(currentNode);

            for (SearchableTree<T> node : rootsNeighbours) {
                if (node.visited) {
                    System.out.println("Someone's been at " + node.data + " before; pathway present");
                    return true;
                } else {
                    node.visited = true;
                    neighbouringNodes.enqueue(node);
                }
            }
        }

        // by now all nodes have been explored
        return false;
    }
}