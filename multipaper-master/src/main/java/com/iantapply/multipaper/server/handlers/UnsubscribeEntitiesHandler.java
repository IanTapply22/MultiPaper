package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.UnsubscribeEntitiesMessage;
import com.iantapply.multipaper.server.EntitiesSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class UnsubscribeEntitiesHandler {
    public static void handle(ServerConnection connection, UnsubscribeEntitiesMessage message) {
        EntitiesSubscriptionManager.unsubscribe(connection, message.world, message.cx, message.cz);
    }
}