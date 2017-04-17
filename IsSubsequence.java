import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    public boolean isSubsequence(String ss, String tt) {
        if(ss.length() == 0) {
            return true;
        }
        char[] s = ss.toCharArray(), t = tt.toCharArray();
        int index = 0;
        for(int j = 0; j < t.length; j++) {
            if(s[index] == t[j]) {
                index++;
                if(index == s.length) {
                    return true;
                }
            }
        }
        return false;
    }

}









