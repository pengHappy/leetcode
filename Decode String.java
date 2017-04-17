import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by zp007 on 9/16/16.
 */

public class Solution {
    public String decodeString(String s) {
        char[] array = s.toCharArray();
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int i = 0;
//        resStack.push("");
        while(i < array.length) {
            if(Character.isDigit(array[i])) {
                int count = 0;
                while(i < array.length && Character.isDigit(array[i])) {
                    count = count * 10 + array[i] - '0';
                    i++;
                }
                countStack.push(count);
            }
            else if(array[i] == '[') {
                resStack.push(res);
                res = "";
                i++;
            }
            else if(array[i] == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int count = countStack.pop();
                while(count-- > 0) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            }
            else {
                res += array[i];
                i++;
            }
        }
        return res;
    }
}









