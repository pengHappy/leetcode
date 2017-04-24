import java.util.*;

/**
 * Created by coffee on 2016/9/18.
 */
public class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if(!stack.isEmpty() && stack.peek() == '?') {
                stack.pop(); // ?
                char first = stack.pop();
                stack.pop(); // :
                char second = stack.pop();
                stack.push(c == 'T' ? first : second);
            }
            else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.pop());
    }
}