package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text container keeps paragraph with the list of its sentences.
 */
public class Paragraph implements TextContainer {

    private List<TextContainer> sentenceList;
    private String paragraph;

    /**
     * Constructs the container which contains the list of sentences.
     *
     * @param paragraph the paragraph of text
     */
    public Paragraph(String paragraph) throws IOException {

        this.paragraph = paragraph;
        this.sentenceList = new ArrayList<>();

        initializeNewTextContainer(this.paragraph);

    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {
        Parser parser = new Parser();
        String regexp = "([^(.|!|?)]+)(.|!|\\?)";
        List<String> sentences = parser.parseTextOnParts(textPart, regexp);

        for (String s : sentences)
            addTextPart(s);
    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        this.sentenceList.add(new Sentence(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.sentenceList)
            result += tc.getTextParts();
        return result;
    }

    @Override
    public List<TextContainer> getTextContainer() {
        return this.sentenceList;
    }

    @Override
    public String toString() {
        return paragraph;
    }
}