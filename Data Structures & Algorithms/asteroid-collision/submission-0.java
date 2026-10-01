class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            int curr = asteroids[i];
            boolean destroyed = false;

            while (!stack.isEmpty() && curr < 0 && stack.peek() > 0) {

                if (stack.peek() < -curr) {
                    stack.pop();
                    continue;
                }
                else if (stack.peek() == -curr) {
                    stack.pop();
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(curr);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
