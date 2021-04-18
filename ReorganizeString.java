
class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];

        for(int i = 0; i < S.length(); i++){
            count[S.charAt(i) - 'a']++;
        }

        int maxCount = 0;
        char maxCountChar = 'a';

        for(int i = 0; i < 26; i++) {
            if(count[i] > maxCount) {
                maxCount = count[i];
                maxCountChar = (char) (i + 'a');
            }
        }

        if (maxCount > (S.length() + 1) / 2) {
            return  "";
        }

        char[] res = new char[S.length()];
        int idx = 0;

        while(count[maxCountChar - 'a'] > 0) {
            res[idx] = maxCountChar;
            idx += 2;
            count[maxCountChar - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                while(count[i] > 0) {
                    if (idx >= S.length()) {
                        idx = 1;
                    }
                    res[idx] = (char) (i + 'a');
                    idx += 2;
                    count[i]--;
                }
            }
        }

        return String.valueOf(res);
    }
}