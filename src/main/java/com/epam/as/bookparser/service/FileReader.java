package com.epam.as.bookparser.service;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Read text from file
 */
public class FileReader {


    public String getTextFromFile(String filename) {
        String text = "";
        try (FileInputStream in = new FileInputStream(filename)) {
            byte[] str = new byte[in.available()];
            in.read(str);
            text = new String(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
        return text;
    }
}