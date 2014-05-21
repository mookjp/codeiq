package io.github.mookjp.codeiq.aegeansea;

import java.util.List;

/**
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
