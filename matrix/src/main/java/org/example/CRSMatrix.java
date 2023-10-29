package org.example;

import java.util.List;
public class CRSMatrix {
    private List<Double> values;
    private List<Integer> rowPtr;
    private List<Integer> colIndices;

    public List<Double> getValues() {
        return values;
    }

    public List<Integer> getRowPtr() {
        return rowPtr;
    }

    public List<Integer> getColIndices() {
        return colIndices;
    }

    public CRSMatrix(List<Double> values, List<Integer> rowPtr, List<Integer> colIndices) {
        this.values = values;
        this.rowPtr = rowPtr;
        this.colIndices = colIndices;
    }

    public int getSize() {
        if (rowPtr == null || rowPtr.isEmpty()) {
            return 0;
        }
        return rowPtr.size() - 1;
    }
}

