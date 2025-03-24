import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first matrix
        System.out.println("Enter elements of the first 2x2 matrix:");
        int[][] matrix1 = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input for the second matrix
        System.out.println("Enter elements of the second 2x2 matrix:");
        int[][] matrix2 = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Menu for operations
        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Transpose of the first matrix");
        System.out.println("4. Transpose of the second matrix");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Addition
                int[][] sum = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        sum[i][j] = matrix1[i][j] + matrix2[i][j];
                    }
                }
                System.out.println("Result of Addition:");
                printMatrix(sum);
                break;

            case 2:
                // Multiplication
                int[][] product = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        product[i][j] = 0;
                        for (int k = 0; k < 2; k++) {
                            product[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                    }
                }
                System.out.println("Result of Multiplication:");
                printMatrix(product);
                break;

            case 3:
                // Transpose of the first matrix
                int[][] transpose1 = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        transpose1[j][i] = matrix1[i][j];
                    }
                }
                System.out.println("Transpose of the first matrix:");
                printMatrix(transpose1);
                break;

            case 4:
                // Transpose of the second matrix
                int[][] transpose2 = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        transpose2[j][i] = matrix2[i][j];
                    }
                }
                System.out.println("Transpose of the second matrix:");
                printMatrix(transpose2);
                break;

            default:
                System.out.println("Invalid choice. Please select a valid operation.");
        }

        scanner.close();
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}