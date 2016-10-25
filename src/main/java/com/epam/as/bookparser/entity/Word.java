package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text container keeps word with the list its characters.
 */
public class Word implements TextContainer {

    private List<TextContainer> symbolList;
    private String word;

    public Word(String word) throws IOException {

        this.word = word;
        this.symbolList = new ArrayList<>();

        initializeNewTextContainer(this.word);
    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {
        Parser parser = new Parser();
        String regexp = "";
        List<String> symbols = parser.parseTextOnParts(textPart, regexp);

        for (String s : symbols)
            addTextPart(s);
    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        //this.symbolList.add(new Symbol(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.symbolList)
            result += tc.getTextParts();
        return word;
    }

    @Override
    public List<TextContainer> getTextContainer() {
        return this.symbolList;
    }

    @Override
    public String toString() {
        return word;
    }
}
