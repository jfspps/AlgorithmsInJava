package com.algo_data.arrays;

public class URLify {
    private final char[] input;

    public URLify(String input) {
        this.input = new char[input.length() * 3];  // prepare to replace one whitespace character with three, %20
        for (int i = 0; i < input.length(); i++){
            this.input[i] = input.charAt(i);
        }
    }

    // without copying to a temporary array, time complexity is O(n^2)
    public String URLifyString(){
        for (int i = 0; i < this.input.length; i++){
            if (this.input[i] == ' '){
                // shuffle elements along three places to the right
                int j = i;

                // send j to the end and back again, shifting each character
                while (this.input[j] != '\0')
                    j++;

                while (j > i){
                    this.input[j+2] = this.input[j];
                    j--;
                }
                this.input[i++] = '%';
                this.input[i++] = '2';
                this.input[i] = '0';
            }
        }
        return new String(this.input).replace("\0", "");
    }
}
