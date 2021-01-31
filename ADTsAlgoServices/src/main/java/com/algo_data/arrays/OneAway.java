package com.algo_data.arrays;

import static java.lang.Math.abs;

public class OneAway {

    // this checks if one string is one operation (add, replace, delete) away from equalling another string.
    // This means that the string is a substring (of another given string) such that there is only one difference

    private final String input;

    public OneAway(String input) {
        this.input = input;
    }

    // time complexity is O(n) (either by sameLengthCompare() or differentLengthCompare())
    public boolean isOneAway(String compareTo){
        if (abs(compareTo.length() - this.input.length()) > 1){
            System.out.println("The supplied string " + compareTo + " is not one away from " + this.input);
            return false;
        }

        int shortestLength;
        if (compareTo.length() < this.input.length()){
            shortestLength = compareTo.length();
        } else
            shortestLength = this.input.length();

        //for strings with the same length, we can only replace one char
        if (this.input.length() == compareTo.length() && !sameLengthCompare(compareTo, shortestLength)){
            System.out.println("The supplied string " + compareTo + " is not one away from " + this.input);
            return false;
        }

        //for strings which differ by one char (replacement op not applicable anymore)
        if (this.input.length() != compareTo.length() && !differentLengthCompare(compareTo, shortestLength)){
            System.out.println("The supplied string " + compareTo + " is not one away from " + this.input);
            return false;
        }

        System.out.println("The supplied string " + compareTo + " is one away from " + this.input);
        return true;
    }

    // time complexity O(n)
    private boolean sameLengthCompare(String compareTo, int length){
        int i = 0;
        int differences = 0;
        while (i < length){
            if (this.input.charAt(i) != compareTo.charAt(i)){
                differences++;
            }

            if (differences > 1){
                return false;
            }
            i++;
        }
        return true;
    }

    // time complexity O(n + n+1) or O(n)
    private boolean differentLengthCompare(String compareTo, int shortest){
        // char replacement not applicable here; can only add or remove a character to/from one string
        int i = 0, j = 0;

        // process the start of both strings (account for insertion)
        while (i < shortest && j < shortest && this.input.charAt(i) == compareTo.charAt(j)){
            i++;
            j++;
        }

        // if we have reached the end of either string then all good (both only differ by one char)
        if (i == shortest || j == shortest){
            return true;
        }

        // if different chars were found but we are not at the end of both strings...
        // there can be only one difference at this stage so conduct one if...else and try to traverse to the end
        if (this.input.charAt(i+1) == compareTo.charAt(j)){
            i++;
            while (this.input.charAt(i) == compareTo.charAt(j) && i < shortest){
                i++;
                j++;
            }
        } else if (this.input.charAt(i) == compareTo.charAt(j+1)){
            j++;
            // try to advance i and j and see if the above if condition was the only difference
            while (this.input.charAt(i) == compareTo.charAt(j) && j < shortest){
                i++;
                j++;
            }
        } else
            return false;

        // if we have reached the end of one of the strings then return true
        return i == shortest - 1 || j == shortest - 1;
    }
}
