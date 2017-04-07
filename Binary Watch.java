import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] h = new int[]{1,2,4,8};
        int[] m = new int[]{1,2,4,8,16,32};
        List<String> ans = new ArrayList<>();
        for(int i = 0; i <= num; i++) {
            List<Integer> res_h = new ArrayList<>();
            generateTime(h, res_h, i, -1, 0, 11);
            List<Integer> res_m = new ArrayList<>();
            generateTime(m, res_m, num - i, -1, 0, 59);
            for(Integer hour : res_h) {
                for(Integer minute : res_m) {
                    ans.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
                }
            }
        }
        return ans;
    }
    public void generateTime(int[] array, List<Integer> res, int k, int index, int sum, int limit) {
        if(sum > limit) {
            return;
        }
        if(k == 0) {
            res.add(sum);
            return;
        }
        for(int i = index + 1; i < array.length; i++) {
            generateTime(array, res, k - 1, i, sum + array[i], limit);
        }
    }
}









