package processor;
import java.util.*;

public class Main {
    public static void readArray(double[][] array) {
        Scanner scanner = new Scanner((System.in));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = scanner.nextDouble();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows1;
        int columns1;
        int rows2;
        int columns2;
        Matrix A;
        double[][] arrayA;
        Matrix B;
        double[][] arrayB;
        int choice;

        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("6. Inverse matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.print("Enter size of first matrix: ");
                    rows1 = scanner.nextInt();
                    columns1 = scanner.nextInt();
                    A = new Matrix(rows1, columns1);
                    System.out.println("Enter first matrix:");
                    arrayA = new double[rows1][columns1];
                    readArray(arrayA);
                    A.setElements(arrayA);
                    System.out.print("Enter size of second matrix: ");
                    rows2 = scanner.nextInt();
                    columns2 = scanner.nextInt();
                    B = new Matrix(rows2, columns2);
                    System.out.println("Enter second matrix:");
                    arrayB = new double[rows2][columns2];
                    readArray(arrayB);
                    B.setElements(arrayB);

                    try {
                        Matrix addition = A.plus(B);
                        System.out.println("The result is:");
                        addition.printMatrix();
                        System.out.println();
                    } catch (IllegalArgumentException e) {
                        System.out.println("The operation cannot be performed.\n");
                    }

                    break;
                case 2:
                    System.out.print("Enter size of matrix: ");
                    rows1 = scanner.nextInt();
                    columns1 = scanner.nextInt();
                    A = new Matrix(rows1, columns1);
                    System.out.println("Enter matrix:");
                    arrayA = new double[rows1][columns1];
                    readArray(arrayA);
                    A.setElements(arrayA);
                    System.out.print("Enter constant: ");
                    double constant = scanner.nextDouble();
                    Matrix constProduct = A.timesConstant(constant);
                    System.out.println("The result is:");
                    constProduct.printMatrix();
                    System.out.println();

                    break;
                case 3:
                    System.out.print("Enter size of first matrix: ");
                    rows1 = scanner.nextInt();
                    columns1 = scanner.nextInt();
                    A = new Matrix(rows1, columns1);
                    System.out.println("Enter first matrix:");
                    arrayA = new double[rows1][columns1];
                    readArray(arrayA);
                    A.setElements(arrayA);
                    System.out.print("Enter size of second matrix: ");
                    rows2 = scanner.nextInt();
                    columns2 = scanner.nextInt();
                    B = new Matrix(rows2, columns2);
                    System.out.println("Enter second matrix:");
                    arrayB = new double[rows2][columns2];
                    readArray(arrayB);
                    B.setElements(arrayB);

                    try {
                        Matrix matrixProduct = A.times(B);
                        System.out.println("The result is:");
                        matrixProduct.printMatrix();
                        System.out.println();
                    } catch (IllegalArgumentException e) {
                        System.out.println("The operation cannot be performed.\n");
                    }

                    break;
                case 4:
                    System.out.println("\n1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    System.out.print("Your choice: ");
                    int transposeChoice = scanner.nextInt();

                    switch (transposeChoice) {
                        case 1:
                            System.out.print("Enter matrix size: ");
                            rows1 = scanner.nextInt();
                            columns1 = scanner.nextInt();
                            A = new Matrix(rows1, columns1);
                            System.out.println("Enter matrix:");
                            arrayA = new double[rows1][columns1];
                            readArray(arrayA);
                            A.setElements(arrayA);
                            B = A.transpose();
                            System.out.println("The result is:");
                            B.printMatrix();
                            System.out.println();
                            break;
                        case 2:
                            System.out.print("Enter matrix size: ");
                            rows1 = scanner.nextInt();
                            columns1 = scanner.nextInt();
                            A = new Matrix(rows1, columns1);
                            System.out.println("Enter matrix:");
                            arrayA = new double[rows1][columns1];
                            readArray(arrayA);
                            A.setElements(arrayA);
                            B = A.transposeAlongSideDiagonal();
                            System.out.println("The result is:");
                            B.printMatrix();
                            System.out.println();
                            break;
                        case 3:
                            System.out.print("Enter matrix size: ");
                            rows1 = scanner.nextInt();
                            columns1 = scanner.nextInt();
                            A = new Matrix(rows1, columns1);
                            System.out.println("Enter matrix:");
                            arrayA = new double[rows1][columns1];
                            readArray(arrayA);
                            A.setElements(arrayA);
                            B = A.transposeAlongVertical();
                            System.out.println("The result is:");
                            B.printMatrix();
                            System.out.println();
                            break;
                        case 4:
                            System.out.print("Enter matrix size: ");
                            rows1 = scanner.nextInt();
                            columns1 = scanner.nextInt();
                            A = new Matrix(rows1, columns1);
                            System.out.println("Enter matrix:");
                            arrayA = new double[rows1][columns1];
                            readArray(arrayA);
                            A.setElements(arrayA);
                            B = A.transposeAlongHorizontal();
                            System.out.println("The result is:");
                            B.printMatrix();
                            System.out.println();
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    System.out.print("Enter matrix size: ");
                    rows1 = scanner.nextInt();
                    columns1 = scanner.nextInt();
                    A = new Matrix(rows1, columns1);
                    System.out.println("Enter matrix:");
                    arrayA = new double[rows1][columns1];
                    readArray(arrayA);
                    A.setElements(arrayA);

                    try {
                        System.out.println("The result is:");
                        System.out.println(A.determinant());
                    } catch (IllegalArgumentException e) {
                        System.out.println("The operation cannot be performed.\n");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter matrix size: ");
                    rows1 = scanner.nextInt();
                    columns1 = scanner.nextInt();
                    A = new Matrix(rows1, columns1);
                    System.out.println("Enter matrix:");
                    arrayA = new double[rows1][columns1];
                    readArray(arrayA);
                    A.setElements(arrayA);

                    try {
                        B = A.inverse();
                        System.out.println("The result is:");
                        B.printMatrix();
                        System.out.println();
                    } catch (ArithmeticException e) {
                        System.out.println("This matrix doesn't have an inverse.");
                    }
                    break;
                default:
                    break;

            }
        }
    }
}
