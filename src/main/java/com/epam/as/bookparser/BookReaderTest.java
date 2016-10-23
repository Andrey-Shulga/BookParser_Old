package com.epam.as.bookparser;

import com.epam.as.bookparser.entity.Text;
import com.epam.as.bookparser.service.FileReader;
import com.epam.as.bookparser.service.FileWriter;

import java.io.IOException;

/**
 * This program parses book (from text file) into its component parts.
 *
 * @author Andrey Shulga
 * @version 1.0.0 2016-10-24
 */
public class BookReaderTest {
    public static void main(String[] args) throws IOException {

        String inFilename = "book.txt";
        String outFilename = "bookCopy.txt";

        FileReader reader = new FileReader();
        FileWriter writer = new FileWriter();

        String fileText = reader.getTextFromFile(inFilename);

        Text text = new Text(fileText);

        writer.writeToFile(fileText, outFilename);

    }
}
