package org.example;

public class DenseMatrixBuilder {
    private int size;
    private double[][] matrix;

    public DenseMatrixBuilder size(int size) {
        this.size = size;
        return this;
    }

    public DenseMatrixBuilder matrix(double[][] matrix) {
        this.matrix = matrix;
        return this;
    }

    public DenseMatrix build() {
        if (size <= 0 || matrix == null || matrix.length != size || matrix[0].length != size) {
            throw new IllegalArgumentException("Invalid size or matrix dimensions.");
        }

        return new DenseMatrix(size, matrix);
    }
}

