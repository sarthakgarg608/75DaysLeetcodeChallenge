class Solution {
    Integer[][] dp;
    int[][] stay;
    int[][] travel;
    int k ;
    int n ;
    public int solve(int day, int curr ){

        if(day >= k) return 0;

        if(dp[day][curr] != null) return dp[day][curr];

        int earnStay = stay[day][curr];
        

        // if tourist stay on this day
        int ans = earnStay + solve(day+1,curr);

        // if tourist visit another city 
        for(int dest = 0 ; dest < n ; dest++){
            int earnTravel = travel[curr][dest];
            ans = Math.max(ans,earnTravel + solve(day+1,dest));
        }
        return dp[day][curr] =  ans;
    }
    public int maxScore(int n, int k, int[][] stay, int[][] travel) {
        // there are n cities that are from 0 .... n-1
        // you have k days 0 ..... k-1
        // if you stay on i day on that city curr earn stayScore[i][curr]
        // if you move from curr city to dest city on i day earn travelScore[curr][dest]

        // maximum possible points the tourist can earn
        this.stay = stay;
        this.travel = travel;
        this.k = k;
        this.n = n;

        dp = new Integer[k][n];



        int ans = 0;

        for(int curr=0;curr<n;curr++){
            ans = Math.max(ans,solve(0,curr));
        }
        return ans;
    }
}