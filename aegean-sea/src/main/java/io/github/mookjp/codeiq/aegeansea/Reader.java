package io.github.mookjp.codeiq.aegeansea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ファイルを読み込むクラスです。
 */
public class Reader {
    protected String filePath;

    public Reader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 島の座標を表す配列を含むListを返します。
     * 例） AegeanSea1.csvの場合、Listの内容は以下になります。
     * [1, 1]
     * [2, 1]
     * [1, 2]
     * [4, 3]
     * [3, 4]
     *
     * @return 島の座標を表す配列を含むList
     */
    public List<int[]> getIslePositions() {
        InputStream is = null;
        try {
            is = new FileInputStream(new File((this.filePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new RuntimeException(e);
        }

        // CSVをパースします。
        // CSV1行ごとのListを作成します。
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        List<String[]> list = br.lines()
                .map(s -> s.split(","))
                .collect(Collectors.toList());

        // 1が含まれる{x, y}を見つけたらListに追加します。
        List<int[]> isles = new ArrayList<>();
        int yCount = 0;
        for (String[] array : list) {
            int xCount = 0;
            for (String s : array) {
                if (s.equals("1")) {
                    int[] islePoint = {xCount, yCount};
                    isles.add(islePoint);
                }
                xCount++;
            }
            yCount++;
        }
        return isles;
    }

}
