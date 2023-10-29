package org.example;

import java.io.IOException;
import java.util.List;

public class Controller {
    public static void controller() throws IOException {
        String filename = "src/main/resources/4884.mtx";

        List<CoordinateMatrix> matrix_coordinate = CoordinateBuilder.processMatrix(filename);
        CRSMatrix crsMatrix = CoordinateToCRSConverter.processMatrix(matrix_coordinate);
        CCSMatrix ccsMatrix = CoordinateToCCSConverter.convert(matrix_coordinate);
        CoordinateToCCSConverter.convert(matrix_coordinate);
        MatrixMultiplication matrixMultiplier = new MatrixMultiplication();
        SparseMatrix result = matrixMultiplier.multiply(crsMatrix, ccsMatrix);
    }
}
