package io.github.mookjp.codeiq.gutenberg;

import java.util.*;

/**
 */
public class GutenBerg {

    public static void main(String[] args) {
        String keyword = args[0];
        String filePath = args[1];

        Map<String, Stack<int[]>> strMap = new BoxReader(filePath).read();
        for (String s :keyword.split("")) {
            int[] position = strMap.get(s).pop();

            System.out.println(Arrays.toString(position) + " = " + s);
        }
    }
}
