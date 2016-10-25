package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text container keeps white space, punctuation mark and word with the list its characters.
 */
public class SentencePart implements TextContainer {

    private List<TextContainer> wordSymbolList;
    private String sentencePart;

    public SentencePart(String sentencePart) throws IOException {

        this.wordSymbolList = new ArrayList<>();
        this.sentencePart = sentencePart;

        initializeNewTextContainer(sentencePart);
    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {
        Parser parser = new Parser();
        String regexp = "";
        List<String> sentenceParts = parser.parseTextOnParts(textPart, regexp);

        for (String sp : sentenceParts)
            addTextPart(sp);
    }


    @Override
    public void addTextPart(String textPart) throws IOException {
        //this.wordSymbolList.add(new SentencePart(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.wordSymbolList)
            result += tc.getTextParts();
        return sentencePart;
    }

    @Override
    public List<TextContainer> getTextContainer() {
        return this.wordSymbolList;
    }

    @Override
    public String toString() {
        return sentencePart;
    }

}
