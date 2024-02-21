package com.badprogram.testtask.view;

import com.badprogram.testtask.FileProcessor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FileChooserGUI extends JFrame {
    private JButton chooseButton;
    private JTextArea resultTextArea;

    public FileChooserGUI() {
        setTitle("File Analyzer");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        chooseButton = new JButton("Choose File");
        resultTextArea = new JTextArea();

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose a .txt file");
                fileChooser.setFileFilter(new FileNameExtensionFilter("Text files (*.txt)", "txt"));

                int result = fileChooser.showOpenDialog(FileChooserGUI.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        new FileProcessor(FileChooserGUI.this).processFile(selectedFile);
                    } catch (IOException exception) {
                        resultTextArea.setText("Something went wrong during file reading: " + exception.getMessage());
                    } catch (RuntimeException exception) {
                        resultTextArea.setText("Something went wrong during data processing: " + exception.getMessage());
                    }
                }
            }
        });

        setLayout(new BorderLayout());

        add(chooseButton, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
    }

    public JTextArea getResultTextArea() {
        return resultTextArea;
    }
}