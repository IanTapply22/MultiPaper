package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.PingMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.BooleanMessageReply;
import com.iantapply.multipaper.server.ServerConnection;

import java.util.concurrent.CompletableFuture;

public class PingHandler {
    public static void handle(ServerConnection connection, PingMessage message) {
        CompletableFuture.runAsync(() -> {
            connection.sendReply(new BooleanMessageReply(true), message);
        });
    }
}
