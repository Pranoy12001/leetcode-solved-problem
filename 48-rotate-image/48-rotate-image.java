class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            int r = 0;
            int c = matrix[i].length - 1;
            
            while (r < c) {
                int temp = matrix[i][r];
                matrix[i][r] = matrix[i][c];
                matrix[i][c] = temp;
                
                r++;
                c--;
            }
        }
    }
}