package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextComposite;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text container keeps word with the list its symbols.
 */
public class Word implements TextComposite {

    private List<TextComposite> symbolList;
    private String word;

    /**
     * Construct the container "Word" which contains the list of its symbols.
     *
     * @param word the word of sentence
     */
    public Word(String word) throws IOException {

        this.word = word;
        this.symbolList = new ArrayList<>();

        initializeNewTextContainer(this.word);
    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {
        Parser parser = new Parser();
        String regexp = ".{1}";
        List<String> symbols = parser.parseTextOnParts(textPart, regexp);

        for (String s : symbols)
            addTextPart(s);
    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        this.symbolList.add(new Symbol(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextComposite tc : this.symbolList)
            result += tc.getSymbol();
        return result;
    }

    @Override
    public List<TextComposite> getTextContainer() {

        return this.symbolList;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException();
    }

}
