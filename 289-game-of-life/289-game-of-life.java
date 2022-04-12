class Solution {
    int dis[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public void gameOfLife(int[][] A) {
        int m = A.length, n = A[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                int res = count(A,i,j,m,n);
                if(A[i][j] == 1){
                    if(res < 2 || res > 3) A[i][j] = -A[i][j];   
                } else{
                    A[i][j] = 2;
                    if (res!=3) A[i][j] = -A[i][j];
                }
            }
        }
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) A[i][j] = A[i][j] < 0 ? 0 : 1;
    }
    
    int count(int[][] A,int i,int j,int m,int n){
        int cnt = 0;
        for(int k = 0; k < 8; k++){
            int x= i + dis[k][0], y = j + dis[k][1];
            if(x >= 0 && y >= 0 && x < m && y < n && Math.abs(A[x][y]) == 1) cnt++;
        }
        return cnt;
    }
}