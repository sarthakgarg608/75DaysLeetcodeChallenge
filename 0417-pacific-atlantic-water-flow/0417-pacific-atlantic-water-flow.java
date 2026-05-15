import java.util.*;

class Solution {

    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};

    public void dfs(int r, int c, int[][] heights, boolean[][] vis){

        vis[r][c] = true;

        int m = heights.length;
        int n = heights[0].length;

        for(int k = 0; k < 4; k++){

            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr >= 0 && nr < m &&
               nc >= 0 && nc < n &&
               !vis[nr][nc] &&
               heights[nr][nc] >= heights[r][c]){

                dfs(nr, nc, heights, vis);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific DFS
        for(int i = 0; i < m; i++){
            dfs(i, 0, heights, pacific);
        }

        for(int j = 0; j < n; j++){
            dfs(0, j, heights, pacific);
        }

        // Atlantic DFS
        for(int i = 0; i < m; i++){
            dfs(i, n - 1, heights, atlantic);
        }

        for(int j = 0; j < n; j++){
            dfs(m - 1, j, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(pacific[i][j] && atlantic[i][j]){

                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}