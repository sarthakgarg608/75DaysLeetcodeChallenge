class Pair{
    int number;
    int op;

    Pair(int number , int op){
        this.number = number;
        this.op = op;
    }
}

class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        boolean[] vis = new boolean[(int)1e7+1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,0));
        while(!q.isEmpty()){
            Pair top = q.remove();
            int num = top.number;
            int op = top.op;
            if(num == y) return op;
            if(!vis[num]){
                vis[num] = true;
                if(num < y) q.add(new Pair(num+1,op+1));
                else{
                    if(num >1) q.add(new Pair(num-1,op+1));
                    
                    if(num%5 == 0 && num != 0) q.add(new Pair(num/5,op+1));
                    if((num%11) == 0 && num != 0) q.add(new Pair(num/11,op+1));
                    q.add(new Pair(num+1,op+1));
                    
                    
                }
            }
        }
        return 0;

        
    }
}