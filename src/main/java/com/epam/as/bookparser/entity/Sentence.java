package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextComposite;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text container keeps the sentence with the list of its sentence's parts: words, white spaces and punctuation marks.
 */
public class Sentence implements TextComposite {
    private List<TextComposite> sentencePartList;
    private String sentence;

    /**
     * If text's part contains word create new text container "Word",
     * otherwise create new component "Symbol".
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

        for (String sp : sentenceParts) {
            if (parser.isWhiteSpaceOrPunctuation(sp, "(\\p{Punct})|(\\s)"))
                this.sentencePartList.add(new Symbol(sp));
            else addTextPart(sp);
        }

    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        this.sentencePartList.add(new Word(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextComposite tc : this.sentencePartList)
            if (tc instanceof Symbol) result += tc.getSymbol();
            else result += tc.getTextParts();
        return result;
    }

    @Override
    public List<TextComposite> getTextContainer() {
        return this.sentencePartList;
    }

    @Override
    public String toString() {
        return sentence;
    }

    @Override
    public String getSymbol() {
        throw new UnsupportedOperationException();
    }

}
