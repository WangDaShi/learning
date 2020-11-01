package com.loatr.learning.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompleteHandler implements CompletionHandler<AsynchronousSocketChannel,SocketServer> {

    @Override
    public void completed(AsynchronousSocketChannel result, SocketServer attachment) {
        attachment.serverChannel.accept(attachment,this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer,buffer,new ReadCompleteHandler(result));
    }

    @Override
    public void failed(Throwable exc, SocketServer attachment) {
        exc.printStackTrace();
    }
}
