package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.SyncChunkOwnerToAllMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.SetChunkOwnerMessage;
import com.iantapply.multipaper.server.ChunkSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class SyncChunkOwnerToAllHandler {
    public static void handle(ServerConnection connection, SyncChunkOwnerToAllMessage message) {
        ServerConnection owner = ChunkSubscriptionManager.getOwner(message.world, message.cx, message.cz);

        ServerConnection.broadcastAll(new SetChunkOwnerMessage(message.world, message.cx, message.cz, owner == null ? "" : owner.getBungeeCordName()));
    }
}
