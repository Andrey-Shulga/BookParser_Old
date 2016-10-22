package com.epam.as.bookparser.service;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Write text to file
 */
public class FileWriter {
    public void writeToFile(String text, String filename) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new java.io.FileWriter(filename))) {
            out.write(text);
        }
    }
}
