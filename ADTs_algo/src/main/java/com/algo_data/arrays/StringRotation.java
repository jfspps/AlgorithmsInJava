package com.algo_data.arrays;

public class StringRotation {
    
    // check if one string is a rotation of another e.g 'brittlebottle' and 'ttlebrittlebo'
    
    private final String stringA;

    public StringRotation(String stringA) {
        this.stringA = stringA;
    }
    
    // scan stringA until two consecutive chars match beginning sequence of chars in stringB;
    // index i always advances one place and the while loop terminates at the end of stringA, hence O(n)
    public boolean compareTo(String stringB){
        if (this.stringA.length() != stringB.length()){
            System.out.println("Can only compare two strings of equal length");
            return false;
        }
        
        int indexA = 0, indexB = 0;
        while (indexA < this.stringA.length()){
            if (this.stringA.charAt(indexA) == stringB.charAt(indexB)){
                // where are we in stringA ??
                if (indexA == this.stringA.length() - 1){
                    // scanned end of stringA, compare the remainder of stringB
                    return endOfStringB_inStringA(stringB, indexB);
                } else {
                    // not at the end, advance indexA and indexB and repeat
                    indexA++;
                    indexB++;
                }
            } else {
                // mismatch, so restart indexB but continue with indexA
                // this also means that we will reach the end of stringA first
                indexA++;
                indexB = 0;
            }
        }

        //traversed stringA without any match
        System.out.println("Supplied string \"" + stringB + "\" is not a rotation of \"" + this.stringA + "\"");
        return false;
    }

    // use this to establish if stringB terminal fragment is at the beginning of this.stringA
    private boolean endOfStringB_inStringA(String stringB, int indexB) {

        // does this.stringA contain the remaining characters, starting from stringB[indexB]...
        if (this.stringA.contains(stringB.substring(indexB +1))){
            System.out.println("Supplied string \"" + stringB + "\" is a rotation of \"" + this.stringA + "\"");
            return true;
        } else {
            System.out.println("Supplied string \"" + stringB + "\" is not a rotation of \"" + this.stringA + "\"");
            return false;
        }
    }
}
