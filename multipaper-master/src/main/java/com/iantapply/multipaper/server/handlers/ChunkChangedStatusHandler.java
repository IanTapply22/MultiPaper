package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.ChunkChangedStatusMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.ServerChangedChunkStatusMessage;
import com.iantapply.multipaper.server.ChunkSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class ChunkChangedStatusHandler {
    public static void handle(ServerConnection connection, ChunkChangedStatusMessage message) {
        for (ServerConnection subscriber : ChunkSubscriptionManager.getSubscribers(message.world, message.cx, message.cz)) {
            subscriber.send(new ServerChangedChunkStatusMessage(message.world, message.cx, message.cz, message.status, connection.getBungeeCordName()));
        }
    }
}
