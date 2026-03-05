package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.LockChunkMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.SetChunkOwnerMessage;
import com.iantapply.multipaper.server.ChunkSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class LockChunkHandler {
    public static void handle(ServerConnection connection, LockChunkMessage message) {
        ServerConnection owner = ChunkSubscriptionManager.lock(connection, message.world, message.cx, message.cz);

        connection.send(new SetChunkOwnerMessage(message.world, message.cx, message.cz, owner.getBungeeCordName()));
    }
}