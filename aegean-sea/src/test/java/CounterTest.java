import io.github.mookjp.codeiq.aegeansea.Counter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 */
public class CounterTest {
    @Test
    public void testCountIsle() throws Exception {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1, 1});
        list.add(new int[] {2, 1});
        list.add(new int[] {1, 2});
        list.add(new int[] {4, 3});
        list.add(new int[] {3, 4});

        int count = Counter.countIsle(list);
        assertThat(count, is(3));
    }

    @Test
    public void upTest() {
       int[] upPos = Counter.up(new int[] {1, 1});
       assertThat(upPos, is(new int[] {1, 0}));
    }

    @Test
    public void leftTest() {
        int[] upPos = Counter.left(new int[] {1, 1});
        assertThat(upPos, is(new int[] {0, 1}));
    }
}
