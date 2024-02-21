package com.badprogram.testtask.view;

import com.badprogram.testtask.FileProcessor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileChooserGUI extends JFrame {
    private JTextArea resultTextArea;

    public FileChooserGUI() {
        setTitle("File Analyzer");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JButton chooseButton = new JButton("Choose File");
        resultTextArea = new JTextArea();

        chooseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose a .txt file");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text files (*.txt)", "txt"));

            int result = fileChooser.showOpenDialog(FileChooserGUI.this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    var fileProcessor = new FileProcessor();
                    var resultReport = fileProcessor.processFile(selectedFile);
                    resultTextArea.setText(resultReport);
                } catch (IOException exception) {
                    resultTextArea.setText("Something went wrong during file reading: " + exception.getMessage());
                } catch (RuntimeException exception) {
                    resultTextArea.setText("Something went wrong during data processing: " + exception.getMessage());
                }
            }
        });

        setLayout(new BorderLayout());

        add(chooseButton, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
    }

}