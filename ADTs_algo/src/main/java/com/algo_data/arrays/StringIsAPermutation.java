package com.algo_data.arrays;

public class StringIsAPermutation {
    private final String input;
    private final int[] tallyArray;     // hold the number of times an ASCII character appears in this string

    public StringIsAPermutation(String input) {
        this.input = input;
        tallyArray = new int[128];  //all elements are padded with zeros
    }

    // time complexity is O(n + 128) or O(n)
    public boolean isAPermutation(String compareToString){
        //build the tally arrays (char's likely to appear in different orders) and then compare
        if (this.input.length() != compareToString.length()){
            System.out.println("Can only compare strings of equal length");
            return false;
        }

        int[] compareToStringTally = new int[128];  // handle ASCII strings only

        for (int i = 0; i < this.input.length(); i++){
            char thisCharacter = this.input.charAt(i);
            char compareCharacter = compareToString.charAt(i);
            if ((int) thisCharacter < 32 || (int) thisCharacter > 159 ||
                    (int) compareCharacter < 32 || (int) compareCharacter > 159){
                System.out.println("Only ASCII characters should be entered.");
                return false;
            }

            this.tallyArray[thisCharacter - 32]++;
            compareToStringTally[compareCharacter - 32]++;
        }

        if (talliesAreEqual(compareToStringTally)){
            System.out.println("Entered string is an anagram (permutation) of " + this.input);
            return true;
        } else {
            System.out.println("Entered string is not an anagram (permutation) of " + this.input);
            return false;
        }
    }

    // helper method to compare the character tallies of this and compareToString
    private Boolean talliesAreEqual(int[] compareToString){
        for (int i = 0; i < this.tallyArray.length; i++){
            if (this.tallyArray[i] != compareToString[i]){
                return false;
            }
        }
        return true;
    }
}
