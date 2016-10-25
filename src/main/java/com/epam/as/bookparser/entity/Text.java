package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.model.TextContainer;
import com.epam.as.bookparser.service.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text container keeps whole the text with list of its paragraphs.
 */
public class Text implements TextContainer {

    private List<TextContainer> paragraphList;
    private String text;

    /**
     * Constructs the container "Paragraph" which contains the list of paragraphs its text.
     *
     * @param text the whole text of book
     */
    public Text(String text) throws IOException {

        this.text = text;
        this.paragraphList = new ArrayList<>();

        initializeNewTextContainer(this.text);

    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {
        Parser parser = new Parser();
        String regexp = ".*(\\r\\n|\\r|\\n)";
        List<String> paragraphs = parser.parseTextOnParts(textPart, regexp);

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
    public List<TextContainer> getTextContainer() {
        return this.paragraphList;
    }

    @Override
    public String toString() {
        return text;
    }
}
