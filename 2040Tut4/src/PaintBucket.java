public class PaintBucket {
    public static void paintBucketFill(int[][] matrix, int row, int col, int newColour) {
        if (newColour != matrix[row][col])// recurse only if change in colour
            paintBucketFill(matrix, row, col, newColour, matrix[row][col]);
    }

    private static void paintBucketFill(int[][] matrix, int row, int col, int newColour, int initColour) {
        if (row <= -1 || row >= matrix.length || col <= -1 || col >= matrix[0].length || matrix[row][col] != initColour)
            return;

        matrix[row][col] = newColour;

        paintBucketFill(matrix, row - 1, col, newColour, initColour);
        paintBucketFill(matrix, row + 1, col, newColour, initColour);
        paintBucketFill(matrix, row, col - 1, newColour, initColour);
        paintBucketFill(matrix, row, col + 1, newColour, initColour);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            } // not particular about extra trailing space here
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] colourMatrix = { { 1, 1, 1, 1, 2, 2, 2, 1 }, { 1, 1, 1, 0, 0, 0, 0, 2 }, { 2, 1, 0, 0, 0, 0, 2, 2 },
                { 1, 0, 0, 0, 0, 0, 2, 2 }, { 2, 0, 0, 2, 2, 2, 1, 1 }, { 2, 0, 0, 2, 2, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 2 } };
        System.out.println("Before fill...");
        printMatrix(colourMatrix);
        System.out.println();
        paintBucketFill(colourMatrix, 2, 3, 2);
        System.out.println("After fill...");
        printMatrix(colourMatrix);
    }
}