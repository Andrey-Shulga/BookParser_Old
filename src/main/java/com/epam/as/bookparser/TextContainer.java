package com.epam.as.bookparser;

/**
 * An interface for access to the container objects.
 */
public interface TextContainer {

    void addTextPart(TextContainer tcont);

    TextContainer getTextPart();

}
