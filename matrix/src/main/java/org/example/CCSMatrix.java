package org.example;

import java.util.List;

public class CCSMatrix {
    private List<Double> values;
    private List<Integer> colPtr;
    private List<Integer> rowIndices;

    public CCSMatrix(List<Double> values, List<Integer> colPtr, List<Integer> rowIndices) {
        this.values = values;
        this.colPtr = colPtr;
        this.rowIndices = rowIndices;
    }

    public List<Double> getValues() {
        return values;
    }

    public List<Integer> getColPtr() {
        return colPtr;
    }

    public List<Integer> getRowIndices() {
        return rowIndices;
    }
    public int getSize() {
        if (colPtr == null || colPtr.isEmpty()) {
            return 0;
        }
        return colPtr.size() - 1;
    }
}
