package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.SetPortMessage;
import com.iantapply.multipaper.server.ServerConnection;

public class SetPortHandler {
    public static void handle(ServerConnection connection, SetPortMessage message) {
        connection.setPort(message.port);
    }
}
