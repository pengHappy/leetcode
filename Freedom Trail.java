import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = key.length(), n = ring.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++) {
                    if(key.charAt(i) == ring.charAt(k)) {
                        int diff = j - k > 0 ? j - k : -(j - k);
                        dp[i][j] = Math.min(diff, n - diff) + dp[i + 1][k];
                    }
                }
            }
        }
        return dp[0][0];
    }
}









