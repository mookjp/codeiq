package io.github.mookjp.codeiq.gutenberg;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 */
public class BoxReaderTest {
    @Test
    public void read() {
        String filePath = "src/test/resources/gutenberg.csv";
        Map<String, Stack<int[]>> strMap = new BoxReader(filePath).read();

        for (String k : strMap.keySet()) {
            System.out.println(k + ":" + strMap.get(k).size());
        }

        int[] expected_a = {2, 0};
        assertThat(strMap.get("A").get(0), is(expected_a));

        int[] expected_space = {2, 8};
        assertThat(strMap.get(" ").get(0), is(expected_space));
    }
}
