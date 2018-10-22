package it.sevenbits.workshop.Matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private Matrix(){}
    private Cell[][] matrix;
    private final int CELL_MAX_VALUE = 100;

    public Matrix(int rowsLen, int colsLen) {
        matrix = new Cell[rowsLen][colsLen];
        fillMatrixWithRandomValues();
    }

    private void fillMatrixWithRandomValues() {
        Random rand = new Random();

        for(int x = 0; x< matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                int cellValue = rand.nextInt(CELL_MAX_VALUE);
                Cell cell = new Cell(x, y, cellValue);
                matrix[x][y] = cell;
            }
        }
    }

    public void Inverse(){
        for(int x = 0; x< matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                matrix[x][y].Inverse();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x< matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                sb.append(matrix[x][y].GetValue()).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
