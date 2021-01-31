package com.algo_data.arrays;

public class ZeroAMatrix {

    // set all elements in any row or column which contains at least one zero element, to zero

    private final int[][] matrix;

    public ZeroAMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public ZeroAMatrix setToZero(){
        // first scan for elements where zero resides and negate all values in the same row and column
        initialiseZeroElements();

        // then scan for negative elements and set them to zero
        for (int row = 0; row < this.matrix.length; row++){
            for (int col = 0; col < this.matrix[0].length; col++){
                if (this.matrix[row][col] < 0){
                    this.matrix[row][col] = 0;
                }
            }
        }
        return this;
    }

    // this helper method looks for zero elements, in preparation for flagZeroElements()
    public ZeroAMatrix initialiseZeroElements(){
        for (int row = 0; row < this.matrix.length; row++){
            for (int col = 0; col < this.matrix[0].length; col++){
                if (this.matrix[row][col] == 0){
                    flagZeroElements(row, col);
                }
            }
        }
        return this;
    }

    // this method negates all elements in the given row and column
    public ZeroAMatrix flagZeroElements(int row_index, int col_index) {
        int row = 0, col = 0;

        // process each row and negate all positive elements in given col_index
        while (row < this.matrix.length){
            if (this.matrix[row][col_index] > 0){
                this.matrix[row][col_index] = -this.matrix[row][col_index];
            }
            row++;
        }

        // process each column and negate all positive elements in the given row_index
        // assume each row is of the same length hence draw from the first row, this.matrix[0].length
        while (col < this.matrix[0].length){
            if (this.matrix[row_index][col] > 0){
                this.matrix[row_index][col] = -this.matrix[row_index][col];
            }
            col++;
        }
        return this;
    }

    public String printMatrix(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] row : this.matrix) {
            for (int col = 0; col < row.length; col++) {
                stringBuilder.append(row[col]);
                stringBuilder.append('\t');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
