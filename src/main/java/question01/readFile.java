package question01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class readFile {

    public static void main(String[] args) throws IOException {

        File file = new File("src/main/java/question01/file.txt");
        String filePath = "src/main/java/question01/file.txt";

        doesFileExist(filePath);
        fileRead(file);

    }

    private static void fileRead(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(" –|,");

                while (lineScanner.hasNext()) {
                    String wordAndMeanings = lineScanner.next();
                    System.out.print(wordAndMeanings + "\n");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean doesFileExist(String path) throws FileNotFoundException {
        File doesExist = new File(path);
        if (doesExist.isFile() && !doesExist.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }
}
