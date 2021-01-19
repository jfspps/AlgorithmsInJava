package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    RotateMatrix matrix;

    @BeforeEach
    void setUp() {
        int[][] newMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        matrix = new RotateMatrix(newMatrix);
    }

    @Test
    void rotateNinetyDegrees() {
        int[][] rotatedMatrix = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        RotateMatrix rotateMatrix = new RotateMatrix(rotatedMatrix);
        String printedRotateMatrix = rotateMatrix.printMatrix();
        String printedTestRotMatrix = matrix.rotateNinetyDegrees().printMatrix();

        assertEquals(printedRotateMatrix, printedTestRotMatrix);
    }

    @Test
    void transposeMatrix() {
        int[][] transposedMatrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        RotateMatrix transposeMatrix = new RotateMatrix(transposedMatrix);
        String printTransposeMatrix = transposeMatrix.printMatrix();
        String printedTestTransMatrix = matrix.transposeMatrix().printMatrix();

        assertEquals(printTransposeMatrix, printedTestTransMatrix);
    }

    @Test
    void flipAlongHorizontal() {
        int[][] flippedMatrix = {
                {3, 2, 1},
                {6, 5, 4},
                {9, 8, 7}
        };
        RotateMatrix flipMatrix = new RotateMatrix(flippedMatrix);
        String printFlippedMatrix = flipMatrix.printMatrix();
        String printedTestFlipMatrix = matrix.flipAlongHorizontal().printMatrix();

        assertEquals(printFlippedMatrix, printedTestFlipMatrix);
    }

    @Test
    void printMatrix() {
        String printedMatrix = "1 2 3 \n4 5 6 \n7 8 9 \n";
        assertEquals(printedMatrix, matrix.printMatrix());
    }
}