public class MinimumSwaps {
    public int minimumSwapsToGroup(int[] arr) {
        int numOnes = 0;

        for(int val: arr) {
            if (val == 1) {
                numOnes++;
            }
        }

        int currNumOnes = 0;
        int numZeros = 0;

        for (int i = 0; i < numOnes; i++) {
            if (arr[i] == 1) {
                currNumOnes++;
            } else {
                numZeros++;
            }
        }

        int maxNumOnes = currNumOnes;
        int minNumZeros = numZeros;

        for (int i = numOnes; i < arr.length; i++) {
            if (arr[i - numOnes] == 1) {
                currNumOnes--;
            } else {
                numZeros--;
            }

            if (arr[i] == 1) {
                currNumOnes++;
            } else {
                numZeros++;
            }

            if (maxNumOnes <= currNumOnes) {
                maxNumOnes = currNumOnes;
                minNumZeros = Math.min(minNumZeros, numZeros);
            }
        }

        return minNumZeros;
    }
}
