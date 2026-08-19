class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
         Stack<TreeNode> st = new Stack<>();
        int i = 0, n = traversal.length();
        while (i < n) {
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(val);
            while (st.size() > depth) {
                st.pop();
            }
            if (!st.isEmpty()) {
                TreeNode parent = st.peek();
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            }
            st.push(node);
        }
        while (st.size() > 1) {
            st.pop();
        }
        return st.peek();
    }
}