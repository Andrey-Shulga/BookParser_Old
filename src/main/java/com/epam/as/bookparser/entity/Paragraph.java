package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class keeps paragraph with the list of sentences.
 */
public class Paragraph implements TextContainer {

    private List<TextContainer> sentenceList;
    private String paragraph;

    /**
     * Constructs the container which contains the list of sentences.
     *
     * @param textPart the paragraph of text
     */
    public Paragraph(String textPart) throws IOException {

        this.paragraph = textPart;
        this.sentenceList = new ArrayList<>();

        Parser parser = new Parser();
        String regexp = "[A-Z].*?[.!?\\n](?=\\s|$)";
        List<String> sentences = parser.parseTextOnParts(textPart, regexp);

        for (String s : sentences) {
            addTextPart(s);
            System.out.println(s);
        }

    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        this.sentenceList.add(new Sentence(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.sentenceList)
            result += tc;
        return result;
    }

    @Override
    public String toString() {
        return paragraph;
    }
}
