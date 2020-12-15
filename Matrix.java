package processor;

import javax.naming.OperationNotSupportedException;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] elements;

    public Matrix(int m, int n) {
        rows = m;
        columns = n;
        elements = new double[rows][columns];
    }

    public void setElements(double[][] array) {
        if (array.length == rows && array[0].length == columns) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    elements[i][j] = array[i][j];
                }
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(elements[i][j] + " ");
                //System.out.print(String.format("%.2f", elements[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public Matrix plus(Matrix B) {
        Matrix A = this;
        if (A.rows == B.rows && A.columns == B.columns) {
            Matrix C = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    C.elements[i][j] = A.elements[i][j] + B.elements[i][j];
                }
            }
            return C;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Matrix timesConstant(double constant) {
        Matrix A = this;
        Matrix B = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                B.elements[i][j] = A.elements[i][j] * constant;
            }
        }
        return B;
    }

    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.columns == B.rows) {
            Matrix C = new Matrix(A.rows, B.columns);
            for (int i = 0; i < C.rows; i++) {
                for (int j = 0; j < C.columns; j++) {
                    C.elements[i][j] = 0;
                    for (int k = 0; k < A.columns; k++) {
                        C.elements[i][j] += A.elements[i][k] * B.elements[k][j];
                    }
                }
            }
            return C;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Matrix transpose() {
        Matrix T = new Matrix(columns, rows);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                T.elements[i][j] = this.elements[j][i];
            }
        }
        return T;
    }

    public Matrix transposeAlongVertical() {
        Matrix T = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                T.elements[i][j] = this.elements[i][columns - 1 - j];
            }
        }
        return T;
    }

    public Matrix transposeAlongHorizontal() {
        Matrix T = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                T.elements[i][j] = this.elements[rows - 1 - i][j];
            }
        }
        return T;
    }

    public Matrix transposeAlongSideDiagonal() {
        Matrix T = this.transposeAlongVertical();
        T = T.transposeAlongHorizontal();
        T = T.transpose();
        return T;
    }

    public double Minor(int i, int j) {
        Matrix M = new Matrix(rows - 1, columns - 1);
        int m = 0;
        for (int auxM = 0; auxM < rows; auxM++) {
            if (auxM == i) {
                continue;
            }
            int n = 0;
            for (int auxN = 0; auxN < columns; auxN++) {
                if (auxN == j) {
                    continue;
                }
                M.elements[m][n] = elements[auxM][auxN];
                n++;
            }
            m++;
        }
        return M.determinant();
    }

    public double cofactor(int i, int j) {
        return Math.pow(-1, i + j) * Minor(i, j);
    }

    public double determinant() {
        if (rows == columns) {
            if (rows == 1) {
                return elements[0][0];
            } else if (rows == 2) {
                return elements[0][0] * elements[1][1] - elements[0][1] * elements[1][0];
            }

            double determinant = 0;
            for (int j = 0; j < columns; j++) {
                determinant += elements[0][j] * cofactor(0, j);
            }
            return determinant;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Matrix inverse() {
        Matrix A = this;
        if (A.determinant() != 0) {
            Matrix I = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    I.elements[j][i] = cofactor(i, j);
                }
            }
            return I.timesConstant(1 / A.determinant());
        } else {
            throw new ArithmeticException();
        }
    }
}
