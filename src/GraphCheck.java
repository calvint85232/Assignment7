//#4
public class GraphCheck {
    public static boolean isDirected(int[][] matrix) {
        int n = matrix.length;

        // check all elements are 0 or 1 and matrix is square
        for (int i = 0; i < n; i++) {
            if (matrix[i].length != n) {
                throw new IllegalArgumentException("Matrix is not square.");
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                    throw new IllegalArgumentException("Matrix elements must be 0 or 1.");
                }
            }
        }

        //check for symmetry to see if its undirected
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return true; // asymmetric, its directed
                }
            }
        }

        return false; // symmetric, undirected
    }
    //TEST RUN
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        if (isDirected(matrix)) {
            System.out.println("The matrix represents a directed graph.");
        } else {
            System.out.println("The matrix represents an undirected graph.");
        }
    }
}