package com.epam.as.bookparser.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Read text from file
 */
public class FileReader {


    public String getTextFromFile(String filename) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) text.append(line);
            return text.toString();
        }
    }
}
