class Solution {
    public void dfs(int r , int c , char[][] board ,int[] dr , int[] dc){
        //vis[r][c] = true;
        board[r][c] = '.';

        for(int k = 0;k<4;k++){
            int nr = r+dr[k];
            int nc= c + dc[k];
            if(nr >=0 && nr < board.length && nc >=0 && nc < board[0].length
            && board[nr][nc] == 'X'){
                dfs(nr,nc,board,dr,dc);

            }
        }

        
    }
    public int countBattleships(char[][] board) {
        //boolean[][] vis = new boolean[board.length][board[0].length];
        //for(boolean[] arr : vis) Arrays.fill(arr,false);

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        int ans = 0;
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'X'){
                    dfs(i,j,board,dr,dc);
                    ans++;
                }
            }
        }
        return ans;

        
    }
}