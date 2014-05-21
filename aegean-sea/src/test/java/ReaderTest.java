import io.github.mookjp.codeiq.aegeansea.Reader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 */
public class ReaderTest {
    @Test
    public void read() {
        String filePath = "src/test/resources/AegeanSea1.csv";

        // Execute
        List<int[]> list = new Reader(filePath).getIslePositions();

        assertThat(list, hasItem(new int[] {1,1}));
        assertThat(list, hasItem(new int[] {2,1}));
        assertThat(list, hasItem(new int[] {1,2}));
        assertThat(list, hasItem(new int[] {4,3}));
        assertThat(list, hasItem(new int[] {3,4}));
    }
}
