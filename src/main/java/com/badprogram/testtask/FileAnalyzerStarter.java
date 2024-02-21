package com.badprogram.testtask;

import com.badprogram.testtask.view.FileChooserGUI;

import javax.swing.*;

public class FileAnalyzerStarter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FileChooserGUI().setVisible(true));
    }
}
