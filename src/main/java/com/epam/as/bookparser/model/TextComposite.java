package com.epam.as.bookparser.model;

import java.io.IOException;
import java.util.List;

/**
 * An universal interface for access to the container and indivisible component.
 */
public interface TextComposite {

    /**
     * Initializes new text container by text's part
     *
     * @param textPart the part of text
     */
    void initializeNewTextContainer(String textPart) throws IOException;

    /**
     * Return the whole text container
     *
     * @return text container
     */
    List<TextComposite> getTextContainer();

    /**
     * Add a part of the text in the container.
     *
     * @param textPart the part of text
     */
    void addTextPart(String textPart) throws IOException;

    /**
     * Return all parts of the text from the container.
     *
     * @return parts of text in that container
     */
    String getTextParts();

    /**
     * Return indivisible component of text part (single symbol)
     *
     * @return symbol
     */
    String getSymbol();
}
