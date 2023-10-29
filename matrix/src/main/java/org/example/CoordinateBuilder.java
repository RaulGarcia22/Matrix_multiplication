package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoordinateBuilder {
    public static List<CoordinateMatrix> matrixReader(String filePath) throws IOException {
        List<CoordinateMatrix> matrix = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean firstLine = true;
        while ((line = reader.readLine()) != null) {
            if (isCommentLine(line)) {
                continue;
            }

            if (firstLine) {
                firstLine = false;
                continue;
            }

            System.out.println(line);
            processAndAddCoordinate(line, matrix);
        }
        reader.close();
        return matrix;
    }

    private static boolean isCommentLine(String line) {
        return line.startsWith("%");
    }

    private static void processAndAddCoordinate(String line, List<CoordinateMatrix> matrix) {
        CoordinateMatrix coordinate = parseCoordinate(line);
        if (coordinate != null) {
            matrix.add(coordinate);
        }
    }

    private static CoordinateMatrix parseCoordinate(String line) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length >= 3) {
            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;
            double value = Double.parseDouble(parts[2]);
            return new CoordinateMatrix(row, col, value);
        }
        return null;
    }

    public static List<CoordinateMatrix> processMatrix(String filename) throws IOException {
        List<CoordinateMatrix> matrix = CoordinateBuilder.matrixReader(filename);
        return matrix;
    }
}

