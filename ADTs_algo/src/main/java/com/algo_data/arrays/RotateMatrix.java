package com.algo_data.arrays;

public class RotateMatrix {

    // this class rotates an NxN matrix 90 degrees to the right
    // the matrix is flipped along the diagonal (transposed) and then flipped vertically

    private final int[][] matrix;

    public RotateMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // in place changes, time complexity is O(N*N/2 + N*N/2) or just O(n^2)
    public RotateMatrix rotateNinetyDegrees(){
        this.transposeMatrix();
        this.flipAlongHorizontal();
        return this;
    }

    // in place changes, time complexity is O(N*N/2) or just O(n^2)
    public RotateMatrix transposeMatrix(){
        // start off of the diagonal, hence second row, this.matrix[1]
        for (int row = 1; row < this.matrix.length; row++){
            // cycle through above row, left-to-right
            // stop when row == col, the diagonal
            for (int col = 0; col < row; col++){
                int temp = this.matrix[row][col];

                // swapping the coords gives the element across the diagonal
                this.matrix[row][col] = this.matrix[col][row];
                this.matrix[col][row] = temp;
            }
        }
        return this;
    }

    // in place changes, time complexity is O(N*N/2) or just O(n^2)
    public RotateMatrix flipAlongHorizontal(){
        for (int row = 0; row < this.matrix.length; row++){
            // perform exchange by swapping the ith element with the [length-(i + 1)]th element
            // until col is halfway along
            for (int col = 0; col < this.matrix.length/2; col++){
                int temp = this.matrix[row][col];
                this.matrix[row][col] = this.matrix[row][this.matrix.length - col - 1];
                this.matrix[row][this.matrix.length - col - 1] = temp;
            }
        }
        return this;
    }

    public String printMatrix(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++){
            for (int j = 0; j < this.matrix[i].length; j++){
                stringBuilder.append(this.matrix[i][j]);
                stringBuilder.append(' ');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
