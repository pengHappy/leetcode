import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16. 
 */

// add some lambda features in java8
public class Solution {
    private interface MathOperation {
        int operation(String a, String b);
    }
    MathOperation transform = (String a, String b) -> Integer.parseInt(a) * 60 + Integer.parseInt(b);
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < timePoints.size() - 1; i++) {
            String a = timePoints.get(i), b = timePoints.get(i + 1);
            diff = Math.min(diff, transform.operation(b.substring(0, 2), b.substring(3)) - transform.operation(a.substring(0, 2), a.substring(3)));
        }
        String first = timePoints.get(0);
        String last = timePoints.get(timePoints.size() - 1);
        return Math.min(diff, transform.operation(first.substring(0, 2), first.substring(3)) + 24 * 60 - transform.operation(last.substring(0, 2), last.substring(3)));
    }
}









