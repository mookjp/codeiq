package io.github.mookjp.codeiq.countfruits;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class CounterTest {

    public final String TESTDATA1 = "{melon (()melon strawberry)][apple}";
    public final String TESTDATA2 = "strawberry (apple {apple }}}strawberry melon){apple strawberry (melon)[}";

    @Test
    public void getRegexTest() {
        String regex = Counter.getRegex("(");
        System.out.println(regex);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(TESTDATA2);

        if (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(group);
            System.out.println(Counter.getFruitsCount(group));
        }
    }
    @Test
    public void getFruitCountTest() {
        assertThat(Counter.getFruitsCount(TESTDATA1), is(4));
        assertThat(Counter.getFruitsCount(TESTDATA2), is(8));
    }

    @Test
    public void getGroupCount() {
        Counter c = new Counter(TESTDATA1);
        assertThat(c.getGroupCount(TESTDATA1, "["), is(0));
        assertThat(c.getGroupCount(TESTDATA1, "("), is(0));
        assertThat(c.getGroupCount(TESTDATA1, "{"), is(4));

        assertThat(c.count(), is(4));
    }

    @Test
    public void getGroupCount2() {
        Counter c = new Counter(TESTDATA2);
        assertThat(c.getGroupCount(TESTDATA2, "["), is(0));
        assertThat(c.getGroupCount(TESTDATA2, "("), is(4));
        assertThat(c.getGroupCount(TESTDATA2, "{"), is(1));

        assertThat(c.count(), is(4));
    }
}
