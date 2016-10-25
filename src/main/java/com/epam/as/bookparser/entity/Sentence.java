package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text container keeps the sentence with the list of its sentence's parts (words, white spaces and punctuation marks).
 */
public class Sentence implements TextContainer {
    private List<TextContainer> sentencePartList;
    private String sentence;

    /**
     * Constructs the container "SentencePart" which contains the list of words, white spaces and punctuation marks its
     * sentence.
     *
     * @param sentence the sentence of paragraph
     */
    public Sentence(String sentence) throws IOException {

        this.sentence = sentence;
        this.sentencePartList = new ArrayList<>();

        initializeNewTextContainer(this.sentence);

    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {

        Parser parser = new Parser();
        String regexp = "([^\\p{Punct}\\s\\t]*[^\\p{Punct}\\s\\t])|(\\p{Punct})|(\\s)";
        List<String> sentenceParts = parser.parseTextOnParts(textPart, regexp);

        for (String sp : sentenceParts)
            addTextPart(sp);
    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        this.sentencePartList.add(new SentencePart(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.sentencePartList)
            result += tc.getTextParts();
        return result;
    }

    @Override
    public List<TextContainer> getTextContainer() {
        return this.sentencePartList;
    }

    @Override
    public String toString() {
        return sentence;
    }
}
