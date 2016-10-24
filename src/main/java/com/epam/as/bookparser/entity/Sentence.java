package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class keeps the list of words, white spaces and punctuations.
 */
public class Sentence implements TextContainer {
    private List<TextContainer> wordsAndMarksList;
    private String sentence;

    /**
     * Constructs the container which contains the list of words and punctuation marks.
     *
     * @param sentence the sentence of text
     */
    public Sentence(String sentence) throws IOException {

        this.sentence = sentence;
        this.wordsAndMarksList = new ArrayList<>();

        initializeNewTextContainer(this.sentence);

    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {

        Parser parser = new Parser();
        String regexp = " ";
        List<String> wordsMarks = parser.parseTextOnParts(textPart, regexp);

        for (String wm : wordsMarks)
            addTextPart(wm);
    }

    @Override
    public void addTextPart(String textPart) {
        // this.wordsAndMarksList.add(new WordAndMark(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.wordsAndMarksList)
            result += tc.getTextParts();
        return result;
    }

    @Override
    public List<TextContainer> getTextContainer() {
        return this.wordsAndMarksList;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
