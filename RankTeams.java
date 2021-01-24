import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int compareTeams(Character t1, Character t2, int[][] alphabetCount) {
        int[] t1Rankings = alphabetCount[t1 - 'A'];
        int[] t2Rankings = alphabetCount[t2 - 'A'];
        int numOfTeams = t1Rankings.length;
        int i = 0;

        while(i < numOfTeams) {
            if (t1Rankings[i] == t2Rankings[i]) {
                i++;
                continue;
            }

            return t2Rankings[i] - t1Rankings[i];
        }

        return Character.compare(t1,t2);
    }

    public String rankTeams(String[] votes) {
        if (votes.length == 0)  return "";

        int numOfTeams = votes[0].length();

        int[][] alphabetCount = new int[26][numOfTeams];

        for (String ranks : votes) {
            for (int j = 0; j < numOfTeams; j++) {
                alphabetCount[(ranks.charAt(j) - 'A')][j]++;
            }
        }

        Character[] teams = new Character[votes[0].length()];
        for (int i = 0; i < votes[0].length(); i++) {
            teams[i] = votes[0].charAt(i);
        }

        Arrays.sort(teams, new Comparator<Character>(){

            @Override
            public int compare(Character t1, Character t2)
            {
                return compareTeams(t1,t2,alphabetCount);
            }
        });

        StringBuilder rankedTeams = new StringBuilder();

        for(Character team: teams) {
            rankedTeams.append(team);
        }

        return rankedTeams.toString();
    }
}