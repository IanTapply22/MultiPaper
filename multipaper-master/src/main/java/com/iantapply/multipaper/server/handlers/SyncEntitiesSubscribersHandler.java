package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.SyncEntitiesSubscribersMessage;
import com.iantapply.multipaper.server.EntitiesSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class SyncEntitiesSubscribersHandler {
    public static void handle(ServerConnection connection, SyncEntitiesSubscribersMessage message) {
        EntitiesSubscriptionManager.syncSubscribers(connection, message.world, message.cx, message.cz);
    }
}
