package com.epam.as.bookparser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This service parses text on parts.
 */
public class ParseService {

    public List<String> findParagraphFromText(String text) {
        String REGEXP_FIND_PARAGRAPH = ".*(\\n)";
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEXP_FIND_PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            list.add(matcher.group());
            //System.out.println(matcher.group());
        }
        return list;
    }
}
