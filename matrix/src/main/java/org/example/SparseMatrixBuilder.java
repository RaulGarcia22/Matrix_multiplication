package org.example;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrixBuilder {
    private int size;
    private List<CoordinateMatrix> coordinates;

    public SparseMatrixBuilder(int size) {
        this.size = size;
        this.coordinates = new ArrayList<>();
    }

    public void set(int row, int col, double value) {
        CoordinateMatrix coordinate = new CoordinateMatrix(row, col, value);
        coordinates.add(coordinate);
    }

    public SparseMatrix toMatrix() {
        return new SparseMatrix(size, coordinates);
    }
}

