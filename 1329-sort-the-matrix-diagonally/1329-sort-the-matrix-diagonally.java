class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            sortDiagonal(mat, i, 0);
        }
        
        for (int j = 1; j < n; j++) {
            sortDiagonal(mat, 0, j);
        }
        
        return mat;
    }
    
    private void sortDiagonal(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        int i = r;
        int j = c;
        
        int[] count = new int[101];
        
        while (i < m && j < n) {
            count[mat[i][j]]++;
            i++;
            j++;
        }
        
        i = r;
        j = c;
        for (int k = 1; k < count.length; k++) {
            while (count[k] > 0) {
                mat[i][j] = k;
                count[k]--;
                i++;
                j++;
            }
        }
    }
}