package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.WriteUidMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.BooleanMessageReply;
import com.iantapply.multipaper.server.ServerConnection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.CompletableFuture;

public class WriteUidHandler {
    public static void handle(ServerConnection connection, WriteUidMessage message) {
        CompletableFuture.runAsync(() -> {
            try {
                File worldDir = new File(message.world);
                if (!worldDir.exists()) worldDir.mkdirs();
                Files.write(new File(worldDir, "uid.dat").toPath(), message.data);
                connection.sendReply(new BooleanMessageReply(true), message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
