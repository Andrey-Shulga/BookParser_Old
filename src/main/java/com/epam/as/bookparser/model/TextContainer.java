package com.epam.as.bookparser.model;

import java.io.IOException;
import java.util.List;

/**
 * An interface for access to the container objects.
 */
public interface TextContainer {

    /**
     * Initializes new TextContainer by text's part
     *
     * @param textPart the part of text
     */
    void initializeNewTextContainer(String textPart) throws IOException;

    /**
     * Return the whole text container
     *
     * @return text container
     */
    List<TextContainer> getTextContainer();

    /**
     * Add a part of the text in the container.
     *
     * @param textPart the par of text
     */
    void addTextPart(String textPart) throws IOException;

    /**
     * Return all parts of the text from the container.
     *
     * @return parts of text in this container
     */
    String getTextParts();

}
