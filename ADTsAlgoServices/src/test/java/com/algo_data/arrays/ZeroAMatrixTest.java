package com.algo_data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroAMatrixTest {

    ZeroAMatrix matrix;

    @BeforeEach
    void setUp() {
        int[][] newMatrix = {
                {1, 2, 3, 1, 2, 3},
                {4, 0, 6, 0, 5, 6},
                {7, 8, 9, 7, 8, 9}
        };
        matrix = new ZeroAMatrix(newMatrix);
    }

    @Test
    void setToZero() {
        int[][] zerodIntMatrix = {
                {1, 0, 3, 0, 2, 3},
                {0, 0, 0, 0, 0, 0},
                {7, 0, 9, 0, 8, 9}
        };

        ZeroAMatrix zerodMatrix = new ZeroAMatrix(zerodIntMatrix);

        assertEquals(zerodMatrix.printMatrix(), matrix.setToZero().printMatrix());
    }

    @Test
    void initialiseZeroElements() {
        int[][] prepMatrix = {
                {1, -2, 3, -1, 2, 3},
                {-4, 0, -6, 0, -5, -6},
                {7, -8, 9, -7, 8, 9}
        };

        ZeroAMatrix preparedMatrix = new ZeroAMatrix(prepMatrix);

        assertEquals(preparedMatrix.printMatrix(), matrix.initialiseZeroElements().printMatrix());
    }

    @Test
    void printMatrix() {
        String output = "1\t2\t3\t1\t2\t3\t\n4\t0\t6\t0\t5\t6\t\n7\t8\t9\t7\t8\t9\t\n";
        assertEquals(output, matrix.printMatrix());
    }
}