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
        RotateMatrix output = new RotateMatrix(this.matrix);
        output.transposeMatrix();
        output.flipAlongHorizontal();
        return output;
    }

    // in place changes, time complexity is O(N*N/2) or just O(n^2)
    public RotateMatrix transposeMatrix(){
        RotateMatrix output = new RotateMatrix(this.matrix);

        // start off of the diagonal, hence second row, this.matrix[1]
        for (int row = 1; row < output.matrix.length; row++){
            // cycle through above row, left-to-right
            // stop when row == col, the diagonal
            for (int col = 0; col < row; col++){
                int temp = output.matrix[row][col];

                // swapping the coords gives the element across the diagonal
                output.matrix[row][col] = output.matrix[col][row];
                output.matrix[col][row] = temp;
            }
        }
        return output;
    }

    // in place changes, time complexity is O(N*N/2) or just O(n^2)
    public RotateMatrix flipAlongHorizontal(){
        RotateMatrix output = new RotateMatrix(this.matrix);

        for (int row = 0; row < output.matrix.length; row++){
            // perform exchange by swapping the ith element with the [length-(i + 1)]th element
            // until col is halfway along
            for (int col = 0; col < output.matrix.length/2; col++){
                int temp = output.matrix[row][col];
                output.matrix[row][col] = output.matrix[row][output.matrix.length - col - 1];
                output.matrix[row][output.matrix.length - col - 1] = temp;
            }
        }
        return output;
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
