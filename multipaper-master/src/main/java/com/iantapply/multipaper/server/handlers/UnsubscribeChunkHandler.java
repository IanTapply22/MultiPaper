package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.UnsubscribeChunkMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.BooleanMessageReply;
import com.iantapply.multipaper.server.ChunkSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class UnsubscribeChunkHandler {
    public static void handle(ServerConnection connection, UnsubscribeChunkMessage message) {
        ChunkSubscriptionManager.unsubscribe(connection, message.world, message.cx, message.cz);

        connection.sendReply(new BooleanMessageReply(true), message);
    }
}
