public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for(int i=0;i<=t.length();i++){
            for(int j=i;j<=s.length();j++){
                if(i==0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                    if(t.charAt(i-1)==s.charAt(j-1)){
                        dp[i][j] += dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}