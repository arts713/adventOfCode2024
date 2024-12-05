package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayData {
    public static List<String> readInput(int day) {
        String filePath = String.format("src/assets/Day%s.txt", day);
        File file = new File(filePath);
        List<String> data = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                data.add(reader.nextLine());
            }
            reader.close();

            return data;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
