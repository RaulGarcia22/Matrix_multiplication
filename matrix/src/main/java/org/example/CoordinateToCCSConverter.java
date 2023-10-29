package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CoordinateToCCSConverter {
    public static CCSMatrix convert(List<CoordinateMatrix> matrix) {
        Map<Integer, TreeMap<Integer, Double>> colToRowValue = createColToRowValueMap(matrix);
        List<Integer> col_ptr = calculateColPointers(colToRowValue);
        List<Integer> row = extractRowIndices(colToRowValue);
        List<Double> value = extractValues(colToRowValue);

        return new CCSMatrix(value, col_ptr, row);
    }

    private static Map<Integer, TreeMap<Integer, Double>> createColToRowValueMap(List<CoordinateMatrix> matrix) {
        Map<Integer, TreeMap<Integer, Double>> colToRowValue = new HashMap<>();
        for (CoordinateMatrix coord : matrix) {
            int col = coord.getCol();
            int row = coord.getRow();
            double val = coord.getValue();

            colToRowValue.computeIfAbsent(col, k -> new TreeMap<>()).put(row, val);
        }
        return colToRowValue;
    }

    private static List<Integer> calculateColPointers(Map<Integer, TreeMap<Integer, Double>> colToRowValue) {
        List<Integer> col_ptr = new ArrayList<>();
        int ptr = 0;
        col_ptr.add(ptr);

        for (int col : colToRowValue.keySet().stream().sorted().collect(Collectors.toList())) {
            int rowValueSize = colToRowValue.get(col).size();
            ptr += rowValueSize;
            col_ptr.add(ptr);
        }
        return col_ptr;
    }

    private static List<Integer> extractRowIndices(Map<Integer, TreeMap<Integer, Double>> colToRowValue) {
        return colToRowValue.values().stream()
                .flatMap(rowValue -> rowValue.keySet().stream())
                .collect(Collectors.toList());
    }

    private static List<Double> extractValues(Map<Integer, TreeMap<Integer, Double>> colToRowValue) {
        return colToRowValue.values().stream()
                .flatMap(rowValue -> rowValue.values().stream())
                .collect(Collectors.toList());
    }
}


