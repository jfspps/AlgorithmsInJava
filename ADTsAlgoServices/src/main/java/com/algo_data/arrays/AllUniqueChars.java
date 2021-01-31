package com.algo_data.arrays;

public class AllUniqueChars {
    private final String input;
    private final int[] tallyArray;

    public AllUniqueChars(String input) {
        this.input = input;
        //assume ASCII here
        this.tallyArray = new int[128];     //all elements are padded with zeros
    }

    // with ADT (i.e. an array which records which characters are present) is O(n)
    public boolean areAllUniqueChars_withADT(){
        for (int i = 0; i < this.input.length(); i++){
            char character = this.input.charAt(i);
            if ((int) character < 32 || (int) character > 159){
                System.out.println("Only ASCII characters should be entered.");
                return false;
            }
            tallyArray[character - 32]++;

            if (tallyArray[character - 32] > 1){
                System.out.println("With ADT. Duplicated character found: " + character);
                return false;
            }
        }
        System.out.println("With ADT. All characters are unique");
        return true;
    }

    // without ADT is O(n^2)
    public boolean areAllUniqueChars_withoutADT(){
        for (int i = 0; i < this.input.length(); i++){
            for (int j = i+1; j < this.input.length(); j++){
                if (this.input.charAt(i) == this.input.charAt(j)){
                    System.out.println("Without ADT. Duplicated character found: " + this.input.charAt(i));
                    return false;
                }
            }
        }
        System.out.println("Without ADT. All characters are unique");
        return true;
    }
}
