package com.ml.ds.compiler.message;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {

    private Message message;
    private List<MessageListener> listeners;

    public MessageHandler() {
        this.listeners = new ArrayList<MessageListener>();
    }

    public void addListener(MessageListener listener) {
        listeners.add(listener);
    }

    public void removeListener(MessageListener listener) {
        listeners.remove(listener);
    }

    public void sendMessage(Message message) {
        this.message = message;

    }

    private void notifyListeners() {
        this.listeners.stream().forEach(l -> l.messageReceived(message));
    }
}
