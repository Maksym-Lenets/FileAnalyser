package com.badprogram.testtask.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationUtils {
    public static Integer getMaxValue(List<Integer> numbers) {
        int maxValue = numbers.get(0);
        for (int i : numbers) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    public static Integer getMinValue(List<Integer> numbers) {
        int minValue = numbers.get(0);
        for (int i : numbers) {
            if (i < minValue) {
                minValue = i;
            }
        }
        return minValue;
    }

    public static double getMedian(List<Integer> numbers) {
        var sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        int mid;
        if (sortedNumbers.size() % 2 == 0) {
            mid = sortedNumbers.size() / 2;
            return (sortedNumbers.get(mid - 1) + sortedNumbers.get(mid)) / 2.0;
        } else {
            return sortedNumbers.get(sortedNumbers.size() / 2);
        }
    }

    public static double calculateAverageValue(List<Integer> numbers) {
        BigDecimal sum = numbers.stream()
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.divide(BigDecimal.valueOf(numbers.size()), 10, RoundingMode.HALF_UP).doubleValue();
    }
}
