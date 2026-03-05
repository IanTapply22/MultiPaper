package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.WritePlayerMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.BooleanMessageReply;
import com.iantapply.multipaper.server.FileLocker;
import com.iantapply.multipaper.server.ServerConnection;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class WritePlayerHandler {
    public static void handle(ServerConnection connection, WritePlayerMessage message) {
        CompletableFuture.runAsync(() -> {
            try {
                FileLocker.writeBytes(new File(new File(message.world, "playerdata"), message.uuid + ".dat"), message.data);
                connection.sendReply(new BooleanMessageReply(true), message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}