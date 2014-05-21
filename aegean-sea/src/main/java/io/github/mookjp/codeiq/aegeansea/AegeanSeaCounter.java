package io.github.mookjp.codeiq.aegeansea;

import java.util.List;

/**
 * メインクラスです。
 * CSVファイルのパスを引数に取り、ファイル名と島の塊の数を出力します。
 */
public class AegeanSeaCounter {

    public static void main(String[] args) {
        for (String path : args) {
            List<int[]> isleList = new Reader(path).getIslePositions();
            int isleCount = Counter.countIsle(isleList);

            System.out.println(path + "," + isleCount);
        }
    }
}
