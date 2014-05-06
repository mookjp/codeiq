import java.util.List;

/**
 */
public class Counter {
    public static int countIsle(List<int[]> isles) {
        if (isles.isEmpty()) return 0;
        int count = 1;

        for (int[] pos : isles) {
            for (int[] targetPos : isles) {
                if (pos.equals(targetPos)) break;
                if (Math.abs(pos[0] - targetPos[0]) == 1
                        && Math.abs(pos[1] - targetPos[1]) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
