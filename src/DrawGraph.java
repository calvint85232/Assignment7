//#6 graphstream wont work
public class DrawGraph {

    public static void main(String[] args) {
        String input = "[ (I, 2) , (A, 5) , (E, 4) , (F, 1) , (T, 2) , (S, 3) ]";
        printAdjacencyMatrix(input);
    }

    public static void printAdjacencyMatrix(String input) {
        // clean up input and split into pairs
        String trimmedInput = input.substring(2, input.length() - 2);
        String[] pairs = trimmedInput.split(" , ");

        // arrays to hold vertices and distances
        String[] vertices = new String[pairs.length];
        int[] distances = new int[pairs.length];

        // parse each pair and populate arrays
        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i].trim(); // "(I, 2)"
            pair = pair.substring(1, pair.length() - 1); // "I, 2"
            String[] parts = pair.split(", ");
            vertices[i] = parts[0];
            distances[i] = Integer.parseInt(parts[1]);
        }

        // initialize adjacency matrix
        int[][] matrix = new int[vertices.length][vertices.length];

        // fill the adjacency matrix
        for (int i = 0; i < vertices.length; i++) {
            int rightIndex = (i + distances[i]) % vertices.length;
            int leftIndex = (i - distances[i] + vertices.length) % vertices.length;

            matrix[i][rightIndex] = 1; // set edge to right vertex
            if (leftIndex != rightIndex) { // prevent duplicate edges in symmetric cases
                matrix[i][leftIndex] = 1; // set edge to left vertex
            }
        }

        // print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // pew line for each vertex
        }
    }
}
