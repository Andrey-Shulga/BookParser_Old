package com.epam.as.bookparser.entity;

import com.epam.as.bookparser.TextContainer;
import com.epam.as.bookparser.service.ParseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Class keep the list of paragraphs.
 */
public class Text implements TextContainer {

    private List<TextContainer> paragraphList;


    public Text(String text) {

        this.paragraphList = new ArrayList<>();
        ParseService parseService = new ParseService();
        List<String> paragraphs = parseService.findParagraphFromText(text);
        for (String p : paragraphs)
            addTextPart(p);


        //for (TextContainer t : paragraphList) System.out.println(t.toString());
    }


    @Override
    public void addTextPart(String textPart) {
        this.paragraphList.add(new Paragraph(textPart));
    }

    @Override
    public TextContainer getTextPart() {

        return null;
    }
}
