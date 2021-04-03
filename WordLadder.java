import java.util.*;

class Solution {
    public void findNextWord(String word, Set<String> s, Queue<String> q) {
        StringBuilder string = new StringBuilder(word);

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            for (int j = 0; j < 26; j++) {
                string.setCharAt(i, (char) ('a' + j));
                String updatedWord = string.toString();

                if(s.contains(updatedWord)) {
                    q.add(updatedWord);
                }
            }
            string.setCharAt(i,c);
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        int len = 1;

        Set<String> s = new HashSet<>(wordList);

        q.add(beginWord);

        while(!q.isEmpty()) {
            int iterationSize = q.size();

            for(int i = 0; i < iterationSize; i++) {
                String word = q.peek();
                q.poll();

                if (word != null && word.equals(endWord)) {
                    return len;
                }

                s.remove(word);

                findNextWord(word, s, q);
            }

            len++;
        }

        return 0;
    }
}