package com.ml.ds.compiler.backend;

import com.ml.ds.compiler.intermediate.ICode;
import com.ml.ds.compiler.intermediate.SymTable;
import com.ml.ds.compiler.message.MessageHandler;
import com.ml.ds.compiler.message.MessageProducer;

public abstract class Backend implements MessageProducer {

	protected static MessageHandler messageHandler;

	static {
		messageHandler = new MessageHandler();
	}

	protected SymTable symTab; // symbol table
	protected ICode iCode; // intermediate code

	public abstract void process(ICode iCode, SymTable symTab) throws Exception;

}
