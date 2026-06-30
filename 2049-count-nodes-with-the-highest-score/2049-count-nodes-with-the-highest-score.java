/**
        If we remove any node from a tree then maximum there will be 3 subtrees:
        1. child1
        2. child2
        3. Parent side
*/
class Solution {
    List<List<Integer>> adj;
    int[] size;

    public void dfs1(int node) {
        int len = adj.get(node).size();

        if (len == 0) return;

        for (int i = 0; i < len; i++) {
            int adjNode = adj.get(node).get(i);

            dfs1(adjNode);
            size[node] += size[adjNode];
        }
    }

    public int countHighestScoreNodes(int[] parents) {
        int totalNode = parents.length;

        adj = new ArrayList<>();
        size = new int[totalNode];

        Arrays.fill(size, 1);

        for (int i = 0; i < totalNode; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < totalNode; i++) {
            adj.get(parents[i]).add(i);
        }

        dfs1(0);

        HashMap<Long, Integer> map = new HashMap<>();

        for (int node = 0; node < totalNode; node++) {
            int child1 = 1;
            int child2 = 1;
            int parent = 1;

            int len = adj.get(node).size();

            if (len == 0) {
                long key = (long) (totalNode - 1);
                map.put(key, map.getOrDefault(key, 0) + 1);
            } else {
                if (len == 1)
                    child1 = size[adj.get(node).get(0)];

                if (len == 2) {
                    child1 = size[adj.get(node).get(0)];
                    child2 = size[adj.get(node).get(1)];
                }

                if (parents[node] != -1)
                    parent = totalNode - size[node];

                long val = 1L * child1 * child2 * parent;

                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }

        long maxKey = Long.MIN_VALUE;
        int value = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getKey() > maxKey) {
                maxKey = entry.getKey();
                value = entry.getValue();
            }
        }

        return value;
    }
}