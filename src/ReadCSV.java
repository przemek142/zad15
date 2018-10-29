import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReadCSV {

    public static List readFile() {

        List lines = null;

        try {
            File file = new File("file.csv");
            lines = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            System.out.println("zła nazwa pliku");
        }
        return lines;
    }
}