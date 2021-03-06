package com.ml.ds.compiler.frontend;

import com.ml.ds.compiler.intermediate.SymTable;
import com.ml.ds.compiler.message.MessageProducer;
import com.ml.ds.compiler.message.MessageHandler;
import com.ml.ds.compiler.message.MessageListener;
import com.ml.ds.compiler.message.Message;

import com.ml.ds.compiler.intermediate.ICode;

public abstract class Parser implements MessageProducer {

    protected static SymTable symTable; // symbol table
    protected static MessageHandler messageHandler;

    static {
        symTable = null;
    }

    protected Scanner scanner;
    // intermediate code generated by parser
    protected ICode iCode;

    public Parser(Scanner scanner) {
        this.scanner = scanner;
        this.iCode = null;
    }

    public abstract void parse() throws Exception;

    // return number of syntax errors found by parser
    public abstract int getErrorCount();

    public Token currentToken() {
        return scanner.currentToken();
    }

    public Token nextToken() throws Exception {
        return scanner.nextToken();
    }

    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
