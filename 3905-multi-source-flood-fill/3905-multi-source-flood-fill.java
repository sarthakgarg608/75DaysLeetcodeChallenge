class Solution {
    class Triplets{
        int val , r , c;
        Triplets(int val , int r , int c){
            this.val = val; this.r = r; this.c = c;
        }
    }

    public int[][] colorGrid(int n, int m, int[][] sources) {

        int[][] ans = new int[n][m];
        Queue<Triplets> que = new LinkedList<>();

        // We can sort the sources 2D Array based on color value
        Arrays.sort(sources, (a,b) -> Integer.compare(a[2] ,b[2]));
        

        int len = sources.length;  // expected TC = O(len log(len)); 
        for(int i = len-1 ; i >= 0 ; i--){
            int r = sources[i][0] , c = sources[i][1] , color = sources[i][2];
            que.add(new Triplets(color,r,c));
            ans[r][c] = color;
        }


        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!que.isEmpty()){
            Triplets top = que.remove();
            int val = top.val , r = top.r , c = top.c;
            for(int i = 0 ; i < 4 ; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && ans[nr][nc] == 0){
                    ans[nr][nc] = val;
                    que.add(new Triplets(val,nr,nc));
                }
            }
        }

        return ans;



    }

}