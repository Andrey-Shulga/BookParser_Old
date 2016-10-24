package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class keeps whole the text with list of its paragraphs.
 */
public class Text implements TextContainer {

    private List<TextContainer> paragraphList;
    private String text;

    /**
     * Constructs the container which contains the list of paragraphs.
     *
     * @param text the whole text of book
     */
    public Text(String text) throws IOException {

        this.text = text;
        this.paragraphList = new ArrayList<>();

        Parser parser = new Parser();
        String regexp = ".*(\\r\\n|\\r|\\n)";
        List<String> paragraphs = parser.parseTextOnParts(text, regexp);

        for (String p : paragraphs) {
            addTextPart(p);
        }

    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        this.paragraphList.add(new Paragraph(textPart));
    }

    @Override
    public String getTextParts() {
        String result = "";
        for (TextContainer tc : this.paragraphList)
            result += tc.getTextParts();
        return result;
    }

    @Override
    public String toString() {
        return text;
    }
}
