package days;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3a {
    public static int run() {
        List<String> data = DayData.readInput("3a");
        int result = 0;

        for (String line: data) {
            if (line.length() == 0) {
                 break;
            }

            Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));

                result += num1 * num2;
            }
        }

        return result;
    }
}
