package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.PlayerConnectMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.BooleanMessageReply;
import com.iantapply.multipaper.server.ServerConnection;

import java.util.List;

public class PlayerConnectHandler {
    public static void handle(ServerConnection connection, PlayerConnectMessage message) {
        List<ServerConnection> connections = ServerConnection.getConnections();

        synchronized (connections) {
            for (ServerConnection otherConnection : connections) {
                if (otherConnection != connection && otherConnection.hasPlayer(message.uuid)) {
                    connection.sendReply(new BooleanMessageReply(false), message);
                    return;
                }
            }

            connection.addPlayer(message.uuid);
        }

        connection.sendReply(new BooleanMessageReply(true), message);
    }
}
