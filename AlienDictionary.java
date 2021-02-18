public class AlienDictionary {
  public boolean comp(String w1, String w2, int[] order) {
    for (int i = 0; i < Math.min(w1.length(), w2.length()); i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
          return order[w1.charAt(i) - 'a'] <= order[w2.charAt(i) - 'a'];
      }
    }
    return w1.length() <= w2.length();
  }

  public boolean isAlienSorted(String[] words, String order) {
    int[] lexOrder = new int[26];
    for (int i = 0; i < order.length(); i++) {
      lexOrder[order.charAt(i) - 'a'] = i;
    }

    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];

      if (!comp(word1, word2, lexOrder)) {
        return false;
      }
    }

    return true;
  }
}
