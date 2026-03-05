package com.iantapply.multipaper.server.handlers;

import com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound.WriteTickTimeMessage;
import com.iantapply.multipaper.mastermessagingprotocol.messages.serverbound.ServerInfoUpdateMessage;
import com.iantapply.multipaper.server.ServerConnection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WriteTickTimeHandler {
    private static final Map<String, Long> lastUpdates = new ConcurrentHashMap<>();

    public static void handle(ServerConnection connection, WriteTickTimeMessage message) {
        connection.getTimer().append(message.tickTime);
        connection.setTps(message.tps);

        if (message.tickTime == -1) {
            connection.setTps(-1);
        }

        if (lastUpdates.getOrDefault(connection.getBungeeCordName(), 0L) < System.currentTimeMillis() - 1000 || connection.getTps() == -1) {
            lastUpdates.put(connection.getBungeeCordName(), System.currentTimeMillis());

            ServerConnection.broadcastAll(new ServerInfoUpdateMessage(connection.getBungeeCordName(), (int) connection.getTimer().averageInMillis(), (float) connection.getTps()));
        }
    }
}