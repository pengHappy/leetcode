import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] lists = new ArrayList[256];
        for(int i = 0 ;i < t.length(); i++) {
            if(lists[t.charAt(i)] == null) {
                lists[t.charAt(i)] = new ArrayList<>();
            }
            lists[t.charAt(i)].add(i);
        }
        int prev = 0;
        for(int i = 0; i < s.length(); i++) {
            if(lists[s.charAt(i)] == null) {
                return false;
            }
            int j = Collections.binarySearch(lists[s.charAt(i)], prev);
            if(j < 0) {
                j = - j - 1;
            }
            if(j == lists[s.charAt(i)].size()) {
                return false;
            }
            prev = lists[s.charAt(i)].get(j) + 1;
        }
        return true;
    }

}









