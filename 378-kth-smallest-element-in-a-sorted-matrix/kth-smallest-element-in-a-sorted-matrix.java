class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    // Efficiently count number of elements ≤ mid
    private int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] <= mid) {
                count += (row + 1);  // all elements above in this column are ≤ mid
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}