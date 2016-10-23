package com.epam.as.bookparser.model;

import java.io.IOException;

/**
 * An interface for access to the container objects.
 */
public interface TextContainer {

    /**
     * Add a part of the text to the container.
     *
     * @param textPart the par of text
     */
    void addTextPart(String textPart) throws IOException;

    /**
     * Return all parts of the text from the container.
     *
     * @return
     */
    String getTextParts();


}
