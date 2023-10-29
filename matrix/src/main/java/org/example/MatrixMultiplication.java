package org.example;


public class MatrixMultiplication {
    public SparseMatrix multiply(CRSMatrix a, CCSMatrix b){
        SparseMatrixBuilder builder = new SparseMatrixBuilder(a.getSize());

        for (int i = 0; i < a.getSize(); i++) {
            for (int j = 0; j < b.getSize(); j++) {
                int ii = a.getRowPtr().get(i);
                int iEnd = a.getRowPtr().get(i + 1);
                int jj = b.getColPtr().get(j);
                int jEnd = b.getColPtr().get(j + 1);
                double s = 0;
                while (ii < iEnd && jj < jEnd) {
                    int aa = a.getColIndices().get(ii);
                    int bb = b.getRowIndices().get(jj);
                    if (aa == bb) {
                        s += a.getValues().get(ii) * b.getValues().get(jj);
                        ii++;
                        jj++;
                    } else if (aa < bb) {
                        ii++;
                    } else {
                        jj++;
                    }

                }
                if (s != 0) {
                    builder.set(i, j, s);
                }

            }
        }
        return builder.toMatrix();
    }
}
