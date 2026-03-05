package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.SubscribeEntitiesMessage;
import com.iantapply.multipaper.server.EntitiesSubscriptionManager;
import com.iantapply.multipaper.server.ServerConnection;

public class SubscribeEntitiesHandler {
    public static void handle(ServerConnection connection, SubscribeEntitiesMessage message) {
        EntitiesSubscriptionManager.subscribe(connection, message.world, message.cx, message.cz);
    }
}
