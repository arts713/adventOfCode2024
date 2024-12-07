package days;

import java.util.List;

public class Day2 {
    public static final int DIFF_MIN = 1;
    public static final int DIFF_MAX = 3;

    public static int run() {
        List<String> data = DayData.readInput(2);

        if (data.isEmpty()) {
            return 0;
        }

        int safeReports = 0;
        for (String line : data) {
            if (Day2.isLineSafe(line)) {
                safeReports += 1;
            }
        }

        return safeReports;
    }

    private static boolean isLineSafe(String line) {
        String[] numbers = line.split(" ");
        if (numbers.length == 0) {
            return false;
        }

        int prevNum = Integer.parseInt(numbers[0]);
        int trend = 0;

        for (int i = 1; i < numbers.length; i++) {
            int currentNum = Integer.parseInt(numbers[i]);
            if (currentNum == prevNum || !isInDiffRange(prevNum, currentNum)) {
                return false;
            }

            int currentTrend = Integer.compare(prevNum, currentNum);
            if (trend == 0) {
                trend = currentTrend;
            } else if (trend != currentTrend) {
                return false;
            }

            prevNum = currentNum;
        }

        return true;
    }

    private static boolean isInDiffRange(int num1, int num2) {
        int diff = Math.abs(num1 - num2);
        return diff >= DIFF_MIN && diff <= DIFF_MAX;
    }
}
