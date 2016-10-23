package com.epam.as.bookparser.service;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Write text to file
 */
public class FileWriter {

    /**
     * Write text to file
     *
     * @param text     the text which needed write
     * @param filename the name of file
     * @throws IOException
     */
    public void writeToFile(String text, String filename) throws IOException {

        try (BufferedWriter out = new BufferedWriter(new java.io.FileWriter((filename)))) {
            out.write(text);
        }
    }
}
