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
    private List<TextContainer> wordsAndSignsList;
    private String sentence;

    public Sentence(String textPart) throws IOException {

        this.sentence = textPart;
        this.wordsAndSignsList = new ArrayList<>();

        Parser parser = new Parser();
        String regexp = " ";
        List<String> wordsSigns = parser.parseTextOnParts(textPart, regexp);

        for (String ws : wordsSigns)
            addTextPart(ws);

    }

    @Override
    public void addTextPart(String textPart) {

    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.wordsAndSignsList)
            result += tc;
        return result;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
