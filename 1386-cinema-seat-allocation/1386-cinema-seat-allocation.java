class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < rs.length; i++){
            int row = rs[i][0];
            int seat = rs[i][1];
            if(map.containsKey(row)){
                map.get(row).add(seat);
            }else{
                map.put(row,new ArrayList<Integer>());
                map.get(row).add(seat);
            }
        }

        int size = map.size();

        // The rows that are not present in hashmap means they do not have any reserved seats 
        // We can allocate at max 2 group in a row 
        int ans = (n-size) * 2;

        for(int row : map.keySet()){
            
            boolean left = true;   // seats 2,3,4,5
    boolean middle = true; // seats 4,5,6,7
    boolean right = true;  // seats 6,7,8,9

    for (int seat : map.get(row)) {
        if (seat >= 2 && seat <= 5) {
            left = false;
        }

        if (seat >= 4 && seat <= 7) {
            middle = false;
        }

        if (seat >= 6 && seat <= 9) {
            right = false;
        }
    }

    if (left && right) {
        ans += 2;
    } else if (left || middle || right) {
        ans += 1;
    }
        }
        return ans;
    }
}