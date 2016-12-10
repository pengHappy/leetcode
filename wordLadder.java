public class Solution {

    public class Node {
        String word;
        int dis;
        public Node(String word, int dis) {
            this.word = word;
            this.dis = dis;
        }
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        Deque<Node> queue = new LinkedList<>();
        queue.offer(new Node(beginWord, 1));
        int count = queue.size();
        while(!queue.isEmpty()) {
            while(count-- > 0) {
                Node node = queue.poll();
//                wordList.remove(node.word);
                int dis = node.dis + 1;
                char[] wordCharArray = node.word.toCharArray();
                for(int i = 0; i < wordCharArray.length; i++) {
                    char origin = wordCharArray[i];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(ch == origin) {
                            continue;
                        }
                        wordCharArray[i] = ch;
                        String newWord = String.valueOf(wordCharArray);
                        if(wordList.contains(newWord) && !visited.contains(newWord)) {
                            if(newWord.equals(endWord)) {
                                return dis;
                            }
                            queue.offer(new Node(newWord, dis));
                            visited.add(newWord);
                        }
                    }
                    wordCharArray[i] = origin;
                }

            }
            count = queue.size();
        }
        return 0;
    }

}