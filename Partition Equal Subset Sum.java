import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    public boolean canPartition(int[] nums) {
        int k = 0;
        int len = nums.length;
        for(int item : nums) {
            k += item;
        }
        if(k % 2 > 0) {
            return false;
        }
        k /= 2;
        boolean[][] dp = new boolean[k + 1][len + 1];
        for(int j = 0; j < dp[0].length; j++) {
            dp[0][j] = true;
        }
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= len; j++) {
                dp[i][j] |= dp[i][j - 1];
                if(i >= nums[j - 1]) {
                    dp[i][j] |= dp[i - nums[j - 1]][j - 1];
                }
            }
        }
        return dp[k][len];
    }
}









