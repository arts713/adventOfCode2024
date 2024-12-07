package days;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3b {
    public static int run() {
        List<String> data = DayData.readInput("3b");
        int result = 0;
        boolean isAllow = true;

        for (String line: data) {
            if (line.length() == 0) {
                 break;
            }

            Pattern pattern = Pattern.compile("(mul\\((\\d+),(\\d+)\\))|(do\\(\\))|(don't\\(\\))");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                if (matcher.group(1) != null && isAllow) {
                    int num1 = Integer.parseInt(matcher.group(2));
                    int num2 = Integer.parseInt(matcher.group(3));

                    result += num1 * num2;
                }

                if (matcher.group(4) != null) {
                    isAllow = true;
                }

                if (matcher.group(5) != null ){
                    isAllow = false;
                }
            }
        }

        return result;
    }
}
