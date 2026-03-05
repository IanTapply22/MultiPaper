package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.UnlockChunkMessage;
import com.iantapply.multipaper.server.ChunkSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class UnlockChunkHandler {
    public static void handle(ServerConnection connection, UnlockChunkMessage message) {
        ChunkSubscriptionManager.unlock(connection, message.world, message.cx, message.cz);
    }
}
