package com.ml.ds.compiler.frontend.pascal;

import com.ml.ds.compiler.frontend.EofToken;
import com.ml.ds.compiler.frontend.Parser;
import com.ml.ds.compiler.frontend.Scanner;
import com.ml.ds.compiler.frontend.Token;
import com.ml.ds.compiler.message.Message;
import com.ml.ds.compiler.message.MessageType;

public class PascalParserTD extends Parser {
    
    public PascalParserTD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void parse() throws Exception {
        Token token;
        long startTime = System.currentTimeMillis();
        
        while (!((token = nextToken()) instanceof EofToken)) {}

        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        
        sendMessage(new Message(MessageType.PARSER_SUMMARY,
                new Number[] {token.getLineNumber(), 
                getErrorCount(), elapsedTime}));
    }

    @Override
    public int getErrorCount() {
        // TODO Auto-generated method stub
        return 0;
    }
}
