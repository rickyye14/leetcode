public class JumpGame {
    public boolean canJump(int[] A) {
        int last = 0;
        int current = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i > last) {
                if (current == last) {
                    return false;
                }
                last = current;
            }
            current = Math.max(current, i + A[i]);
        }
        return true;
    }
}
