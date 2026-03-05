package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.WillSaveEntitiesLaterMessage;
import com.iantapply.multipaper.server.EntitiesLockManager;
import com.iantapply.multipaper.server.ServerConnection;

public class WillSaveEntitiesHandler {
    public static void handle(ServerConnection connection, WillSaveEntitiesLaterMessage message) {
        EntitiesLockManager.lockUntilWrite(message.world, message.cx, message.cz);
    }
}
