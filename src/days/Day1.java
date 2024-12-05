package days;

import java.util.Arrays;
import java.util.List;

public class Day1 {
    public static int run() {
        List<String> data = DayData.readInput(1);
        String[] firstArr = new String[data.size()];
        String[] secondArr = new String[data.size()];

        for (int i = 0; i < data.size(); i++) {
            String el = data.get(i);
            String[] parts = parseLine(el);
            firstArr[i] = parts[0];
            secondArr[i] = parts[1];
        }

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        int result = 0;

        for (int i = 0; i < firstArr.length; i++) {
            int num1 = Integer.parseInt(firstArr[i]);
            int num2 = Integer.parseInt(secondArr[i]);
            result += Math.abs(num1 - num2);
           result += Math.abs(Math.max(Integer.parseInt(firstArr[i]), Integer.parseInt(secondArr[i])) -  Math.min(Integer.parseInt(firstArr[i]), Integer.parseInt(secondArr[i])));
        }

        return result;
    }

    private static String[] parseLine(String line) {
        return line.split("\\s+");
    }
}
