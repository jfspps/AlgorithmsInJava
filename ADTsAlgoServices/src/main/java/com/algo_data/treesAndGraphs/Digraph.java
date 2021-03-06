package com.algo_data.treesAndGraphs;

public class Digraph {

    private Character label;
    private Digraph[] children;

    public Digraph(Character label, Digraph child, int nodeCount){
        this.children = new Digraph[nodeCount];
        this.children[this.children.length - 1] = child;
        this.label = label;
    }
}
