package com.algo_data.stacksAndQueues;

import java.util.LinkedList;
import java.util.List;

public class DogsAndCats {

    private final LinkedList<String> dogs;
    private final LinkedList<String> cats;
    public static final String DOG = "dog";
    public static final String CAT = "cat";

    public DogsAndCats() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    // add new animals to the end of the List
    // time complexity is based on getToFirstNull(), hence O(n) where n is the number of cats or dogs, as appropriate, are present
    /**
     * Adds an animal to the shelter; use "cat" or "dog" as the type
     * */
    public void enqueue(String name, String type){
        int firstNull;
        if (type.equalsIgnoreCase(CAT)){
            firstNull = getToFirstNull(cats);
            cats.add(firstNull, name);
        } else if (type.equalsIgnoreCase(DOG)){
            firstNull = getToFirstNull(dogs);
            dogs.add(firstNull, name);
        } else {
            System.out.println("Expecting either cat or dog as second argument");
        }
    }

    // time complexity is O(n)
    private int getToFirstNull(LinkedList<String> animalList) {
        int counter = 0;

        while (counter < animalList.size()){
            if (animalList.get(counter) == null){
                break;
            }
            counter++;
        }
        return counter;
    }

    // time complexity is constant, O(1)
    /**
     * Returns the name of the next available animal at the shelter; use "cat" or "dog" as the type
     * */
    public String peek(String type){
        if (type.equalsIgnoreCase(CAT)){
            return cats.get(0);
        } else if (type.equalsIgnoreCase(DOG)){
            return dogs.get(0);
        } else {
            System.out.println("Expecting either cat or dog as second argument");
            return null;
        }
    }

    // time complexity is constant, O(1)
    /**
     * Returns true of there are no animals of given type and false otherwise; use "cat" or "dog" as the type
     * */
    public boolean noneAtShelter(String type){
        if (type.equalsIgnoreCase(CAT)){
            return cats.isEmpty();
        } else if (type.equalsIgnoreCase(DOG)){
            return dogs.isEmpty();
        } else {
            System.out.println("Expecting either cat or dog as second argument");
            return true;
        }
    }

    // time complexity is based on reshuffle, i.e. O(n)
    /**
     * If possible, removes and returns a dog's name from the shelter and null if there are none
     * */
    public String dequeueDog(){
        if (dogs.get(0) == null){
            System.out.println("No more dogs at the shelter");
            return null;
        }

        String dogsName = dogs.get(0);
        dogs.remove(0);
        return dogsName;
    }

    // time complexity is based on reshuffle, i.e. O(n)
    /**
     * If possible, removes and returns a cat's name from the shelter and null if there are none
     * */
    public String dequeueCat(){
        if (cats.get(0) == null){
            System.out.println("No more cats at the shelter");
            return null;
        }

        String catsName = cats.get(0);
        cats.remove(0);
        return catsName;
    }

    // time complexity is based on reshuffle, i.e. O(n)
    /**
     * If possible, removes and returns a animal's name from the shelter, giving precedence to the most prevalent animal
     * type. If there are equal cats and dogs, then a cat is released. Returns null if the animal shelter is empty.
     * */
    public String dequeueAny(){
        // returns an animal from the most populated list
        if (cats.isEmpty() && dogs.isEmpty()){
            System.out.println("No animals at the shelter");
            return null;
        }

        String animalName;
        boolean catAdopted = false;
        if (cats.size() >= dogs.size()){
            animalName = cats.get(0);
            catAdopted = true;
        } else {
            animalName = dogs.get(0);
        }

        if (catAdopted){
            cats.remove(0);
        } else
            dogs.remove(0);

        return animalName;
    }
}