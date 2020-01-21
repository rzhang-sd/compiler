package com.ml.ds.compiler.frontend;

import com.ml.ds.compiler.message.Message;
import com.ml.ds.compiler.message.MessageType;
import com.ml.ds.compiler.message.MessageListener;
import com.ml.ds.compiler.message.MessageProducer;

import java.io.BufferedReader;
import java.io.IOException;

public class Source implements MessageProducer {

	// end-of-line
	public static final char EOL = '\n';

	// end-of-file character
	public static final char EOF = (char) 0;

	private BufferedReader reader;

	private String line;

	private int lineNum;

	private int currentPos;

	public Source(BufferedReader reader) throws IOException {
		this.lineNum = 0;
		this.currentPos = -2; // set to -2 to read the first source line
		this.reader = reader;
	}

	/**
	 * Return the source character at the current position.
	 * 
	 * @return the source character at the current position.
	 * @throws Exception if an error occurred.
	 */
	public char currentChar() throws Exception {

		// First time?
		if (currentPos == -2) {
			readLine();
			return nextChar();
		} else if (line == null) {
			// end of file
			return EOF;
		} else if ((currentPos == -1) || (currentPos == line.length())) {
			// end of line
			return EOL;
		} else if (currentPos > line.length()) {
			// Need to read the next line?
			readLine();
			return nextChar();
		}
		// Return the character at the current position. else {
		return line.charAt(currentPos);
	}

	public char nextChar() throws Exception {
		++currentPos;
		return currentChar();
	}

	/**
	 * 
	 * @return the char following current char without consuming the current char
	 * @throws Exception
	 */
	public char peekChar() throws Exception {
		currentChar();
		if (line == null) {
			return EOF;
		}
		int nextPos = currentPos + 1;
		return nextPos < line.length() ? line.charAt(nextPos) : EOL;
	}

	public void close() throws Exception {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public int getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}

	public void addMessageListener(MessageListener listener) {
		// TODO Auto-generated method stub

	}

	public void removeMessageListener(MessageListener listener) {
		// TODO Auto-generated method stub

	}

	public void sendMessage(Message message) {
		// TODO Auto-generated method stub

	}

	private void readLine() throws IOException {
		line = reader.readLine(); // null when at the end of the source
		currentPos = 0;

		if (line != null) {
			++lineNum;
		}

		if (line != null) {
			sendMessage(new Message(MessageType.SOURCE_LINE, new Object[] { lineNum, line }));
		}
	}
}
