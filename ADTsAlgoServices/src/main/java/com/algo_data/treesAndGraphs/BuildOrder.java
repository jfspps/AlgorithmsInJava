package com.algo_data.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BuildOrder {

    private List<List<Character>> listOfProjectPairs;
    private Set<Character> projects;

    public BuildOrder(List<List<Character>> listOfProjects, Set<Character> allProjects) {
        if (listOfProjects.get(0).size() != 2){
            System.out.println("Projects must be build as pairs");
            return;
        }
        this.listOfProjectPairs = listOfProjects;
        this.projects = allProjects;
    }

    public boolean isBuildable(){
        Set<Character> allProjects = this.projects;

        List<Character> projects = new ArrayList<>();
        for (List<Character> project : this.listOfProjectPairs){
            projects.add(project.get(1));
        }

        // none of the projects can be built first; first remove projects from dependencies
        allProjects.removeAll(projects);

        if (allProjects.isEmpty()){
            System.out.println("No valid build order present");
            return false;
        }

        System.out.println("The following can be built first: ");
        for (Character character : allProjects){
            System.out.print(character + " ");
        }
        System.out.println();
        return true;
    }
}
