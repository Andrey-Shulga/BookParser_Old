package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.TextContainer;
import com.epam.as.bookparser.service.ParseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Class keep the list of sentences.
 */
public class Paragraph implements TextContainer {

    private List<TextContainer> sentenceList;
    private String paragraphText;

    public Paragraph(String textPart) {
        paragraphText = textPart;
        this.sentenceList = new ArrayList<>();
        ParseService parseService = new ParseService();
        //  List<String> sentences = parseService.findParagraphFromText(textPart);
        //   for (String p : sentences)
        //       addTextPart(p);


    }

    @Override
    public void addTextPart(String textPart) {
        this.sentenceList.add(new Paragraph(textPart));
    }

    @Override
    public String getTextPart() {
        //  for (TextContainer this: )
        return null;
    }

    @Override
    public String toString() {
        return paragraphText;
    }
}
