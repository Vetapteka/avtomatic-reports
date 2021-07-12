import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static String absolutePathLab6 = "E:\\prog\\vetka6lab_ULTRA\\src\\main\\java\\staying\\alive";
    public static String contains = "";

    public static void main(String[] args) {
        File report = new File("E:\\prog\\sameDir\\report1111.txt");

        try {
            if (report.createNewFile()) {
                FileWriter writer = new FileWriter(report, true);
                File lab = new File(absolutePathLab6); // create new File as object
                File[] paths = lab.listFiles();

                fileCopy(paths, writer);

                writer.close();
                System.out.println(contains);

            } else {
                System.out.println("The file has already been created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void fileCopy(File[] paths, FileWriter writer) {

        for (File path : paths) { // needs down
            if (path.isFile()) {
                try {
                    writer.write(path.getName());
                    contains = contains + path.getName() + '\n';

                    writer.append('\n');

                    FileReader reader = new FileReader(path);
                    int c;
                    while ((c = reader.read()) != -1) {
                        writer.write((char) c);
                    }
                    writer.append('\n');
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (path.isDirectory()) {
                fileCopy(path.listFiles(), writer);

            }

        }
    }
}