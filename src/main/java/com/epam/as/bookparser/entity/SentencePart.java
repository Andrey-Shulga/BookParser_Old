package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text container keeps the word or the white space or the punctuation mark.
 * If text's part is a word (contains 2 or more symbols) it keeps Text Container with the list of its symbols.
 */
public class SentencePart implements TextContainer {

    private List<TextContainer> wordList;
    private String sentencePart;
    private final int LENGTH_OF_WORD = 1;

    /**
     * If text's part is a word (contains 2 or more symbols) then constructing the container "Word" which contains the
     * list of symbols its word.
     *
     * @param sentencePart the part of sentence
     */
    public SentencePart(String sentencePart) throws IOException {

        this.wordList = new ArrayList<>();
        this.sentencePart = sentencePart;

        if (this.sentencePart.length() > LENGTH_OF_WORD)
            initializeNewTextContainer(this.sentencePart);
    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {
        Parser parser = new Parser();
        String regexp = ".{1}";
        List<String> words = parser.parseTextOnParts(textPart, regexp);

        for (String w : words)
            addTextPart(w);
    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        this.wordList.add(new Word(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.wordList)
            result += tc.getTextParts();
        return result;
    }

    @Override
    public List<TextContainer> getTextContainer() {
        return this.wordList;
    }

    @Override
    public String toString() {
        return sentencePart;
    }

}
