package com.algo_data.arrays;

public class StringCompression {

    // this compresses a string from dooodleZOOOoM to do3dleZO3oM

    private final String input;

    public StringCompression(String input){
        this.input = input;
    }

    // time complexity is O(i + j) (higher indices i would reduce j, and vice versa for consecutive elements) or just O(n)
    public String compress(){
        //i tail pointer, j lead pointer, k traverses compressedString[]
        int i = 0, j, k = 0;
        char[] compressedString = new char[this.input.length()];

        while (i < this.input.length()){
            compressedString[k++] = this.input.charAt(i);
            int tally = 1;      // there is one of compressedString[i]

            // pointer j moves one element ahead of pointer i and looks for repeated characters
            for (j = i+1; j < this.input.length(); j++){
                if (this.input.charAt(i) == this.input.charAt(j)){
                    tally++;
                } else {
                    // no repeated characters, let i catch up to j
                    break;
                }
            }
            i = j;

            // add digit if there are repeated characters
            if (tally > 1) {
                compressedString[k++] = Character.forDigit(tally, 10);
            }
        }
        return new String(compressedString).replace("\0", "");
    }
}
