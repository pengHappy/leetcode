import java.util.*;

/**
 * Created by coffee on 2016/9/18.
 */
public class Solution {
    public class TrieNode {
        public List<String> startsWith;
        public TrieNode[] children;
        public TrieNode() {
            startsWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    public class Trie {
        private TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            for(String word : words) {
                char[] array = word.toCharArray();
                TrieNode current = root;
                for(char c : array) {
                    if(current.children[c - 'a'] == null) {
                        current.children[c - 'a'] = new TrieNode();
                    }
                    current.startsWith.add(word);
                    current = current.children[c - 'a'];
                }
            }
        }
        public List<String> findByPrefix(String prefix) {
            char[] array = prefix.toCharArray();
            List<String> ans = new ArrayList<>();
            TrieNode current = root;
            for(char c : array) {
                if(current.children[c - 'a'] == null) {
                    return ans;
                }
                current = current.children[c - 'a'];
            }
            ans.addAll(current.startsWith);
            return ans;
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        List<String> ansSquare = new ArrayList<>();
        int len = words[0].length();
        Trie trie = new Trie(words);
        for(String word : words) {
            ansSquare.add(word);
            helper(res, ansSquare, len, trie);
            ansSquare.remove(ansSquare.size() - 1);
        }
        return res;
    }
    private void helper(List<List<String>> res, List<String> ansSquare, int len, Trie trie) {
        if(ansSquare.size() == len) {
            res.add(new ArrayList<>(ansSquare));
            return;
        }
        int index = ansSquare.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for(int i = 0; i < index; i++) {
            prefixBuilder.append(ansSquare.get(i).charAt(index));
        }
        List<String> potentialWords = trie.findByPrefix(prefixBuilder.toString());
        for(String word : potentialWords) {
            ansSquare.add(word);
            helper(res, ansSquare, len, trie);
            ansSquare.remove(ansSquare.size() - 1);
        }
    }
}