package io.github.mookjp.codeiq.aegeansea;

import java.util.Arrays;
import java.util.List;

/**
 * 島の塊の数を数えるクラスです。
 */
public class Counter {

    /**
     * 島のある座標のListを引数にとり、塊と判定される島の数を返します。
     *
     * 島が上下左右にある場合、そこは船が通れないのでひとつの「島の固まり」として数えます。
     * 島が斜めに並んでいる場合、そこは船が通れるので、固まりとは数えません。
     *
     * @param isles 島のある座標のList
     * @return 島の塊と判定される島の数
     */
    public static int countIsle(List<int[]> isles) {
        int count = 0;

        if (isles.isEmpty()) return count;

        // 島の隣に島があったら、カウントします
        for (int[] pos : isles) {
            for (int[] targetPos: isles) {
                if (Arrays.equals(targetPos, up(pos)) ||
                        Arrays.equals(targetPos, down(pos)) ||
                        Arrays.equals(targetPos, right(pos)) ||
                        Arrays.equals(targetPos, left((pos)) )) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int[] up(int pos[]) {
        return new int[] {pos[0], pos[1] - 1};
    }

    public static int[] down(int pos[]) {
        return new int[] {pos[0], pos[1] + 1};
    }

    public static int[] right(int pos[]) {
        return new int[] {pos[0] + 1, pos[1]};
    }

    public static int[] left(int pos[]) {
        return new int[] {pos[0] - 1, pos[1]};
    }
}
