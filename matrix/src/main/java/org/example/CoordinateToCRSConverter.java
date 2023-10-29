package org.example;

import java.util.ArrayList;
import java.util.List;

public class CoordinateToCRSConverter {
    public static CRSMatrix convertToCRS(List<CoordinateMatrix> coordinateMatrix) {
        List<Double> values = extractValues(coordinateMatrix);
        List<Integer> rowPtr = calculateRowPointers(coordinateMatrix);
        List<Integer> colIndices = extractColumnIndices(coordinateMatrix);
        return new CRSMatrix(values, rowPtr, colIndices);
    }


    private static List<Double> extractValues(List<CoordinateMatrix> coordinateMatrix) {
        List<Double> values = new ArrayList<>();

        for (CoordinateMatrix coordinate : coordinateMatrix) {
            values.add(coordinate.getValue());
        }

        return values;
    }

    private static List<Integer> calculateRowPointers(List<CoordinateMatrix> coordinateMatrix) {
        int numElements = coordinateMatrix.size();
        List<Integer> rowPtr = new ArrayList<>();
        rowPtr.add(0);

        for (int i = 1; i < numElements; i++) {
            CoordinateMatrix coord = coordinateMatrix.get(i);

            if (coord.getRow() != coordinateMatrix.get(i - 1).getRow()) {
                rowPtr.add(i);
            }
        }
        rowPtr.add(numElements);

        return rowPtr;
    }

    private static List<Integer> extractColumnIndices(List<CoordinateMatrix> coordinateMatrix) {
        List<Integer> colIndices = new ArrayList();

        for (CoordinateMatrix coordinate : coordinateMatrix) {
            colIndices.add(coordinate.getCol());
        }

        return colIndices;
    }

    public static CRSMatrix processMatrix(List<CoordinateMatrix> coordinateMatrix) {
        CRSMatrix matrix = convertToCRS(coordinateMatrix);
        return matrix;
    }
}


