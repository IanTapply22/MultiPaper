package com.iantapply.multipaper.mastermessagingprotocol.messages.masterbound;

import com.iantapply.multipaper.mastermessagingprotocol.ExtendedByteBuf;

public class RequestEntityIdBlock extends MasterBoundMessage {

    public RequestEntityIdBlock() {

    }

    public RequestEntityIdBlock(ExtendedByteBuf byteBuf) {

    }

    @Override
    public void write(ExtendedByteBuf byteBuf) {

    }

    @Override
    public void handle(MasterBoundMessageHandler handler) {
        handler.handle(this);
    }
}
