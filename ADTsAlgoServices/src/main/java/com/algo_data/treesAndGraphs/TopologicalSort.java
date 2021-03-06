package com.algo_data.treesAndGraphs;

// demonstrates a topological sort, such that tasks are performed in the 'correct' order

import java.util.ArrayList;
import java.util.HashMap;

public class TopologicalSort {

    // define the Node structure of a connected graph (child node may have more than one dependent, or parent)
    public class Node {
        private ArrayList<Node> children = new ArrayList<>();

        // map holds references to the children's neighbouring nodes (nieces and nephews)
        // use a HashMap to locate nodes, by name
        private HashMap<String, Node> map = new HashMap<>();

        private String name;
        private int dependencies = 0;

        public Node(String name) {
            this.name = name;
        }

        // build dependents
        public void addNeighbour(Node neighbour){
            if (!map.containsKey(neighbour.getName())){
                children.add(neighbour);
                map.put(neighbour.getName(), neighbour);
                neighbour.dependencies++;
            }
        }

        public String getName() {
            return name;
        }

        public ArrayList<Node> getChildren() {
            return children;
        }

        public int getDependencies() {
            return dependencies;
        }
    }

    // define the directed graph structure
    public class Graph {
        private ArrayList<Node> nodes = new ArrayList<>();
        private HashMap<String, Node> map = new HashMap<>();

        public Node buildOrGetNode(String name){
            if (!map.containsKey(name)){
                Node node = new Node(name);
                nodes.add(node);
                map.put(name, node);
            }

            return map.get(name);
        }

        public void buildEdge(String parent, String child){
            Node start = buildOrGetNode(parent);
            Node finish = buildOrGetNode(child);

            start.addNeighbour(finish);
        }

        public ArrayList<Node> getNodes() {
            return nodes;
        }
    }

    // build a list of nodes in the buildable order
    public Node[] buildList(ArrayList<Node> nodes){
        Node[] ordered = new Node[nodes.size()];

        // handle nodes with zero dependencies first; nodes with dependencies will start from listOffset
        int listOffset = 0;
        for (Node node : nodes){
            if (node.getDependencies() == 0){
                ordered[listOffset++] = node;
            }
        }

        // now, by level, process each node which are dependent on nodes in list 'nodes'
        int nodesToBeProcessed = 0;

        while (nodesToBeProcessed < ordered.length){
            // take out the node which has dependencies, if any, already handled
            Node currentNode = ordered[nodesToBeProcessed];

            // do not build if there are no nodes with zero dependencies at this level
            if (currentNode == null){
                return null;
            }

            ArrayList<Node> children = currentNode.getChildren();
            // for each child, remove one dependent (i.e. currentNode)
            for (Node node : children){
                node.dependencies--;
            }

            // add each child to the ordered list and increase nodesToBeProcessed so the loop can terminate
            for (Node node : children){
                if (node.getDependencies() == 0){
                    ordered[listOffset++] = node;
                }
            }
            nodesToBeProcessed++;
        }

        return ordered;
    }

    // take a list of paired nodes (x, y), by name, where y depends on x, or x -> y
    // dependencies[].size() would equal the number of edges involved
    // it is assumed dependencies[][0] is x and dependencies[][1] is y
    Graph buildGraph(String[][] dependencies){
        Graph graph = new Graph();

        for (String[] dependent : dependencies){
            String first = dependent[0];
            String second = dependent[1];
            graph.buildEdge(first, second);
        }

        return graph;
    }

    // take a graph with established edges and use it to finally build an ordered array of nodes, in build order
    public Node[] findBuildOrder(String[][] dependencies){
        Graph graph = buildGraph(dependencies);
        return buildList(graph.getNodes());
    }
}
