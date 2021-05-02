class Solution {
  public String breakPalindrome(String palindrome) {
    int len = palindrome.length();

    if (len == 1) {
      return "";
    }

    char[] sb = palindrome.toCharArray();

    for (int i = 0; i < len / 2; i++) {
      if (palindrome.charAt(i) != 'a') {
        sb[i] = 'a';

        return String.valueOf(sb);
      }
    }

    sb[len - 1] = 'b';

    return String.valueOf(sb);
  }
}
