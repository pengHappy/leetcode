import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] ss = s.toCharArray();
        int ans = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < ss.length; right++) {
            map.put(ss[right], map.getOrDefault(ss[right], 0) + 1);
            while(map.size() > k) {
//                if(map.containsKey(ss[left])) {
                    map.put(ss[left], map.get(ss[left]) - 1);
                    if(map.get(ss[left]) == 0) {
                        map.remove(ss[left]);
                    }
//                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}









