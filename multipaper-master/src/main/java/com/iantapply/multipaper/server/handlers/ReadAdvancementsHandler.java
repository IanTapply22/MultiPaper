package com.iantapply.multipaper.server.handlers;


import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.ReadAdvancementMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.DataMessageReply;
import com.iantapply.multipaper.server.FileLocker;
import com.iantapply.multipaper.server.ServerConnection;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class ReadAdvancementsHandler {
    public static void handle(ServerConnection connection, ReadAdvancementMessage message) {
        CompletableFuture.runAsync(() -> {
            try {
                byte[] b = FileLocker.readBytes(new File(new File(message.world, "advancements"), message.uuid + ".json"));
                connection.sendReply(new DataMessageReply(b), message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}