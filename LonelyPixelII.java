import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    private String generateKey(char[][] picture, int x, int N, int[] col) {
        int count = 0;
        for(int i = 0; i < picture[0].length; i++) {
            if(picture[x][i] == 'B') {
                count++;
                col[i]++;
            }
        }
        if(count == N) {
            StringBuilder sb = new StringBuilder();
            for(char ch : picture[x]) {
                sb.append(ch);
            }
            return sb.toString();
        }
        else {
            return "";
        }
    }
    public int findBlackPixel(char[][] picture, int N) {
        int m = picture.length;
        if(m == 0) {
            return 0;
        }
        int n = picture[0].length;
        if(n == 0) {
            return 0;
        }
        int[] col = new int[n];
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < m; i++) {
            String key = generateKey(picture, i, N, col);
            if(key.length() > 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        for(HashMap.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(value == N) {
                for(int i = 0; i < n; i++) {
                    if(key.charAt(i) == 'B' && col[i] == N) {
                        count += N;
                    }
                }
            }
        }
        return count;
    }
}









