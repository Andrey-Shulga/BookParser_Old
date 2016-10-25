package com.epam.as.bookparser.entity;


import com.epam.as.bookparser.model.TextComposite;

import java.io.IOException;
import java.util.List;

/**
 * Text component contains only 1 symbol
 */
class Symbol implements TextComposite {

    private String ch;

    /**
     * Construct text indivisible component
     *
     * @param ch
     */
    Symbol(String ch) {
        this.ch = ch;
    }

    @Override
    public String getSymbol() {
        return this.ch;
    }

    @Override
    public void initializeNewTextContainer(String textPart) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComposite> getTextContainer() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addTextPart(String textPart) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getTextParts() {
        throw new UnsupportedOperationException();
    }

}
