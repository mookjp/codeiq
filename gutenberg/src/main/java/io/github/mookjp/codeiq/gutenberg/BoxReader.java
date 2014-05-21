package io.github.mookjp.codeiq.gutenberg;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 活字のCSVを読み込みます。
 */
public class BoxReader {
    String filePath;
    Map<String, Stack<int[]>> strMap;

    public BoxReader(String filePath) {
        this.filePath = filePath;
        read();
    }

    /**
     * CSVを読み込んで、文字をキー、座標のStackをバリューにしたMapを返します。
     *
     * @return 文字をキー、座標のStackをバリューにしたMa
     */
    public Map<String, Stack<int[]>> read() {
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
                .map(s -> StringUtils.strip(s).split("\",\""))
                .collect(Collectors.toList());

        // 文字のMapを作成します
        strMap = new HashMap<>();
        int yCount = 0;
        for (String[] array : list) {
            int xCount = 0;
            for (String s : array) {
                if (strMap.keySet().contains(s)) {
                    Stack<int[]> posStack = strMap.get(s);
                    posStack.add(new int[]{xCount, yCount});
                } else {
                    Stack<int[]> posStack = new Stack<>();
                    posStack.add(new int[]{xCount, yCount});
                    strMap.put(s, posStack);
                }
                xCount++;
            }
            yCount++;
        }
        return strMap;
    }
}

