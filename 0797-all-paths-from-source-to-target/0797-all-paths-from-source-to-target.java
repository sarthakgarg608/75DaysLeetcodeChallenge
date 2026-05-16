class Solution {
    public void dfs(int[][] graph , int node , int target , List<Integer> ans,List<List<Integer>> result){
        
        ans.add(node);
        if(node == target){
            result.add(new ArrayList<>(ans));
            ans.remove(ans.size()-1);
            return;
        }
        if(graph[node].length == 0){
            ans.remove(ans.size()-1);
            return ;
        }
        for(int i =0;i<graph[node].length;i++){
            dfs(graph,graph[node][i] , target, ans,result);
        }
        ans.remove(ans.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int source = 0 , target = graph.length-1;
        List<List<Integer>> result = new ArrayList<>();
        dfs(graph,0,target,new ArrayList<>(),result);
        return result;
        
    }
}