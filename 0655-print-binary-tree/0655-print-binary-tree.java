class Solution {
    public int getLevels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getLevels(root.left),getLevels(root.right));
    }
    int levels;
    public void dfs(TreeNode root , int r , int c , String[][] str){
        if(root.left != null){
            int newr = r+1;
            int newc = c-(int)(Math.pow(2,levels-2-r));
            str[newr][newc] = (root.left.val+"");
            dfs(root.left,newr,newc,str);
        }
        if(root.right != null){
            int newr = r+1;
            int newc = c+(int)(Math.pow(2,levels-2-r));
            str[newr][newc] = (root.right.val+"");
            dfs(root.right,newr,newc,str);
        }

    }
    public List<List<String>> printTree(TreeNode root) {
        // total number of rows is basically the levels of binary tree(m)
        // total number of columns is (2^m -1) ->(n)
        // if a node is at the cell (r,c) -> left (r+1,c-(2^m-2-r)) , right -> (r+1,c+(2^m-2-r))
        // for initial node the 'c' will be (n-1)/2

        levels = getLevels(root);
        int m = levels , n = (int)(Math.pow(2,levels)-1);
        String[][] str = new String[m][n];
        for(String[] arr : str) Arrays.fill(arr,"");

        str[0][(n-1)/2] = (root.val+"");
        dfs(root,0,(n-1)/2,str);
        
        List<List<String>> result = new ArrayList<>();
        for(int i =0;i<m;i++){
            result.add(new ArrayList<>());
        }
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                result.get(i).add(str[i][j]);
            }
        }
        return result;




        
    }
}
