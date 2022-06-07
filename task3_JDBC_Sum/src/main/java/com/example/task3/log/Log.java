package com.example.task3.log;

import com.sun.javafx.binding.Logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
    private static Logger LOGGER = Logger.getLogger(Logging.class.getName());

    static {
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("/logManager.log");
            LOGGER = Logger.getLogger(Logging.class.getName());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String message) {
        LOGGER.log(Level.INFO, message);
    }
}
