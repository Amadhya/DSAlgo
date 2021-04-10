import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for(int ast: asteroids) {
            if (ast > 0) {
                s.push(ast);
            } else {
                while( !s.isEmpty() && Math.abs(ast) > s.peek() && s.peek() > 0) {
                    s.pop();
                }

                if (!s.isEmpty() && Math.abs(ast) == s.peek() && s.peek() > 0) {
                    s.pop();
                } else if (s.isEmpty() || s.peek() < 0) {
                    s.push(ast);
                }
            }
        }

        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--)
            res[i] = s.pop();

        return res;
    }
}