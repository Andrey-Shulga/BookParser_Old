package com.epam.as.bookparser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This service parses text on parts.
 */
public class Parser {

    /**
     * Parse text on separate parts.
     *
     * @param textPart the text for parse
     * @param regexp   the regular expression for parse
     * @return the list with separate parts
     */
    public List<String> parseTextOnParts(String textPart, String regexp) {

        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexp, 32);
        Matcher matcher = pattern.matcher(textPart);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public boolean isWhiteSpaceOrPunctuation(String textPart, String regexp) {
        Pattern pattern = Pattern.compile(regexp, 32);
        Matcher matcher = pattern.matcher(textPart);
        return matcher.find();
    }

}
