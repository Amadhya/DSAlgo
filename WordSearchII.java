import java.util.LinkedList;
import java.util.List;

class TrieNode {
  TrieNode[] children = new TrieNode[26];
  boolean isEnd;
}

class Solution {
  public TrieNode getTree(String[] words) {
    TrieNode root = new TrieNode();

    for (String word : words) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        int idx = c - 'a';

        if (node.children[idx] == null) {
          node.children[idx] = new TrieNode();
        }
        node = node.children[idx];
      }

      node.isEnd = true;
    }

    return root;
  }
  
  public void dfs(char[][] board, int y, int x, String curr, TrieNode root, List<String> res) {
    if (y < 0 || x < 0 || y >= board.length || x >= board[0].length) {
      return;
    }

    char currChar = board[y][x];

    if (currChar == '*') {
      return;
    }

    TrieNode child = root.children[currChar - 'a'];

    if (child == null) {
      return;
    }

    String newCurr = curr + currChar;

    if (child.isEnd) {
      res.add(newCurr);
      child.isEnd = false;
    }

    board[y][x] = '*';

    dfs(board, y - 1, x, newCurr, child, res);
    dfs(board, y + 1, x, newCurr, child, res);
    dfs(board, y, x + 1, newCurr, child, res);
    dfs(board, y, x - 1, newCurr, child, res);

    board[y][x] = currChar;
  }

  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new LinkedList<>();
    TrieNode root = getTree(words);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        dfs(board, i, j, "", root, res);
      }
    }

    return res;
  }
}
