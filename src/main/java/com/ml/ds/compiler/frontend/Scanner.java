package com.ml.ds.compiler.frontend;

public abstract class Scanner {

	protected Source source;
	private Token currentToken;

	public Scanner(Source source) {
		this.source = source;
	}

	public Token currentToken() {
		return currentToken;
	}

	public Token nextToken() throws Exception {
		currentToken = extractToken();
		return currentToken;
	}

	public char currentChar() throws Exception {
		return source.currentChar();
	}

	public char nextChar() throws Exception {
		return source.nextChar();
	}

	protected abstract Token extractToken() throws Exception;
}
