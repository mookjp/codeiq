import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class Reader {
    protected String filePath;

    public Reader(String filePath) {
        this.filePath = filePath;
    }

    public List<int[]> getIslePositions() {
        InputStream is = null;
        try {
            is = new FileInputStream(new File((this.filePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new RuntimeException(e);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        List<String[]> list = br.lines()
                .map(s -> s.split(","))
                .collect(Collectors.toList());

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
