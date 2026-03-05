package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.WillSaveChunkLaterMessage;
import com.iantapply.multipaper.server.ChunkLockManager;
import com.iantapply.multipaper.server.ServerConnection;

public class WillSaveChunkHandler {
    public static void handle(ServerConnection connection, WillSaveChunkLaterMessage message) {
        ChunkLockManager.lockUntilWrite(message.world, message.cx, message.cz);
    }
}
