package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.TextContainer;
import com.epam.as.bookparser.service.ParseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Class keep the list of paragraphs..
 */
public class Text implements TextContainer {

    private List<TextContainer> paragraphList;


    public Text(String text) {

        paragraphList = new ArrayList<>();
        ParseService parseService = new ParseService();
        List<String> paragraphs = parseService.findParagraphFromText(text);
        for (String p : paragraphs)
            paragraphList.add(new Paragraph(p));
        //  for (TextContainer t : paragraphList) System.out.println(t.toString());
    }


    @Override
    public void addTextPart(TextContainer tcont) {

    }

    @Override
    public TextContainer getTextPart() {

        return null;
    }
}
