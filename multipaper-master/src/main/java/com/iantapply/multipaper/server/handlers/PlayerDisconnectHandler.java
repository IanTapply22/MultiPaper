package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.PlayerDisconnectMessage;
import com.iantapply.multipaper.server.ServerConnection;

public class PlayerDisconnectHandler {
    public static void handle(ServerConnection connection, PlayerDisconnectMessage message) {
        connection.removePlayer(message.uuid);
    }
}
