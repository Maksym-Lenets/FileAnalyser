package com.badprogram.testtask;

import com.badprogram.testtask.util.CalculationUtils;
import com.badprogram.testtask.util.IOUtils;
import com.badprogram.testtask.util.LogicProcessUtils;
import com.badprogram.testtask.view.FileChooserGUI;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileProcessor {
    private final FileChooserGUI fileChooserGUI;

    public FileProcessor(FileChooserGUI fileChooserGUI) {
        this.fileChooserGUI = fileChooserGUI;
    }

    public void processFile(File file) throws IOException {
        long startTime = System.nanoTime();
        var finalReportData = new LinkedHashMap<String, Object>();

        List<Integer> numbers = IOUtils.readNumbersFromFileReader(file);
        finalReportData.put("Number of numbers read", numbers.size());

        Integer maxNumber = CalculationUtils.getMaxValue(numbers);
        finalReportData.put("Max number", maxNumber);

        Integer minNumber = CalculationUtils.getMinValue(numbers);
        finalReportData.put("Min number", minNumber);

        double averageValue = CalculationUtils.calculateAverageValue(numbers);
        finalReportData.put("Average value", averageValue);

        double median = CalculationUtils.getMedian(numbers);
        finalReportData.put("Median", median);

        String increasingSequence = LogicProcessUtils.getLongestSequenceOfIncreasingNumbersDescription(numbers);
        finalReportData.put("Increasing sequence", increasingSequence);

        String decreasingSequence = LogicProcessUtils.getLongestSequenceOfDecreasingNumbersDescription(numbers);
        finalReportData.put("Decreasing sequence", decreasingSequence);

        long endTime = System.nanoTime();
        long spentTimeMs = (endTime - startTime) / 1_000_000;
        finalReportData.put("Time spent on file processing (milliseconds)", spentTimeMs);

        fileChooserGUI.getResultTextArea().setText(createFinalReport(finalReportData));
    }

    private String createFinalReport(Map<String, Object> results) {
        StringBuilder resultReport = new StringBuilder();
        int rowCounter = 0;
        for (var pair : results.entrySet()) {
            resultReport.append(++rowCounter);
            resultReport.append(". ");
            resultReport.append(pair.getKey());
            resultReport.append(": ");
            resultReport.append(pair.getValue().toString());
            resultReport.append("\n");
        }

        return resultReport.toString();
    }


}
