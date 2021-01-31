package com.algo_data.arrays;

public class Palindrome {

    // a palindrome contains characters which have an even number of appearances or none at all;
    // only one character can have an odd number of appearances

    private final String input;
    private final int[] tally;

    public Palindrome(String input) {
        this.input = input;
        this.tally = new int[128];     //need only concern with alphabetical characters
    }

    // time complexity is O(n + 128) or just O(n)
    public boolean stringIsAPermutationOfAPalindrome(){
        //tally up the characters
        for (int i = 0; i < this.input.length(); i++){
            char character = this.input.charAt(i);
            if ((int) character < 32 || (int) character > 159){
                System.out.println("Only ASCII characters should be entered.");
                return false;
            }
            this.tally[character - 32]++;
        }

        int numberOfOdd = 0;
        //scan tally
        for (int i : this.tally) {
            if (i % 2 != 0) {
                numberOfOdd++;
            }

            if (numberOfOdd > 1) {
                System.out.println(this.input + " is not a permutation of a palindrome");
                return false;
            }
        }
        System.out.println(this.input + " is a permutation of a palindrome");
        return true;
    }
}
