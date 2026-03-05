package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.SyncChunkSubscribersMessage;
import com.iantapply.multipaper.server.ChunkSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class SyncChunkSubscribersHandler {
    public static void handle(ServerConnection connection, SyncChunkSubscribersMessage message) {
        ChunkSubscriptionManager.syncSubscribers(connection, message.world, message.cx, message.cz);
    }
}
