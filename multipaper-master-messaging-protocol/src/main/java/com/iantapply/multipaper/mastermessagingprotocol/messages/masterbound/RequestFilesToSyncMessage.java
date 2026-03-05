package com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound;

import com.iantapply.multipaper.mastermessagingprotocol.ExtendedByteBuf;

public class RequestFilesToSyncMessage extends MasterBoundMessage {

    public RequestFilesToSyncMessage() {

    }

    public RequestFilesToSyncMessage(ExtendedByteBuf byteBuf) {

    }

    @Override
    public void write(ExtendedByteBuf byteBuf) {

    }

    @Override
    public void handle(MasterBoundMessageHandler handler) {
        handler.handle(this);
    }
}
