package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.SubscribeChunkMessage;
import com.iantapply.multipaper.server.ChunkSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class SubscribeChunkHandler {
    public static void handle(ServerConnection connection, SubscribeChunkMessage message) {
        ChunkSubscriptionManager.subscribe(connection, message.world, message.cx, message.cz);
    }
}