package com.ml.ds.compiler.frontend;

public class Token {

    protected TokenType type;
    protected Source source;

    // token text
    protected String text;
    // token value
    protected Object value;
    // line number of the token's source line
    protected int lineNum;
    // position of the first char in token
    protected int position;

    public Token(Source source) throws Exception {
        this.source = source;
        this.lineNum = source.getLineNum();
        this.position = source.getCurrentPos();

        extract();
    }

    protected void extract() throws Exception {
        text = Character.toString(currentChar());
        value = null;
        nextChar();
    }

    protected char currentChar() throws Exception {
        return source.currentChar();
    }

    protected char nextChar() throws Exception {
        return source.nextChar();
    }

    // return next char from the source without moving forward
    protected char peekChar() throws Exception {
        return source.peekChar();
    }
}
