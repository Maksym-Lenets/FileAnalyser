package com.badprogram.testtask;

import com.badprogram.testtask.view.FileChooserGUI;

import javax.swing.*;
import java.io.IOException;

public class FileAnalyzerStarter {
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileChooserGUI().setVisible(true);
            }
        });

    }
}
