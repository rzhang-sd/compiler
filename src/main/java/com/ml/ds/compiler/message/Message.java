package com.ml.ds.compiler.message;

public class Message {

	private MessageType type;
	private Object body;

	public Message(MessageType type, Object body) {
		this.type = type;
		this.body = body;
	}
}
