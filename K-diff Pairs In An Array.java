import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int item : nums) {
            hashMap.put(item, hashMap.getOrDefault(item, 0) + 1); // good!
        }
        int count = 0;
        for(HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(k == 0) {
                count += entry.getValue() > 1 ? 1 : 0;
            }
            else if(hashMap.containsKey(entry.getKey() + k)) {
                count++;
            }
        }
        return count;
    }
}









