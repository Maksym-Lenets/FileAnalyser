package com.badprogram.testtask.util;

import java.util.List;

public class LogicProcessUtils {
    private final static int DEFAULT_INIT_VALUE = 0;

    public static String getLongestSequenceOfIncreasingNumbersDescription(List<Integer> numbers) {
        return longestSequenceDescription(numbers, true);
    }

    public static String getLongestSequenceOfDecreasingNumbersDescription(List<Integer> numbers) {
        return longestSequenceDescription(numbers, false);
    }

    private static String longestSequenceDescription(List<Integer> numbers, boolean increasing) {
        String sequenceType = increasing ? "increasing" : "decreasing";

        int longestStartIndex = DEFAULT_INIT_VALUE;
        int longestEndIndex = DEFAULT_INIT_VALUE;

        int currentStartIndex = DEFAULT_INIT_VALUE;
        int currentEndIndex = DEFAULT_INIT_VALUE;

        for (int i = 1; i < numbers.size(); i++) {
            boolean condition = increasing ? numbers.get(i) > numbers.get(i - 1) : numbers.get(i) < numbers.get(i - 1);
            if (condition) {
                currentEndIndex = i;
            } else {
                if ((longestEndIndex - longestStartIndex) < (currentEndIndex - currentStartIndex)) {
                    longestStartIndex = currentStartIndex;
                    longestEndIndex = currentEndIndex;
                }
                currentStartIndex = i;
            }
        }

        if ((longestEndIndex - longestStartIndex) < (currentEndIndex - currentStartIndex)) {
            longestStartIndex = currentStartIndex;
            longestEndIndex = currentEndIndex;
        }


        if (longestStartIndex == longestEndIndex && longestEndIndex == DEFAULT_INIT_VALUE) {
            return "Sequence not found.";
        }

        return String.format("The longest sequence of %s numbers starts with element #%d (value is %d) and ends at element #%d (value is %d). " +
                        "Total - %d %s elements in turn.",
                sequenceType,
                longestStartIndex + 1, numbers.get(longestStartIndex),
                longestEndIndex + 1, numbers.get(longestEndIndex),
                longestEndIndex - longestStartIndex + 1,
                sequenceType);

    }
}
