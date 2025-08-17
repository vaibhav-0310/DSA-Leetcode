class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Use a List to store the coordinates of all original zeros.
        // This is better than a fixed-size array.
        List<int[]> zeroCoordinates = new ArrayList<>();

        // PASS 1: Find all original zeros and store their locations.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroCoordinates.add(new int[]{i, j});
                }
            }
        }

        // PASS 2: Iterate through the stored coordinates and set rows/columns to zero.
        for (int[] coords : zeroCoordinates) {
            int r = coords[0];
            int c = coords[1];

            // Set entire row 'r' to zero
            for (int j = 0; j < cols; j++) {
                matrix[r][j] = 0;
            }

            // Set entire column 'c' to zero
            for (int i = 0; i < rows; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}