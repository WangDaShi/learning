package com.loatr.learning.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class SocketServer {

    public AsynchronousServerSocketChannel serverChannel;

    public void start() throws IOException {
        serverChannel = AsynchronousServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress("127.0.0.1",8081));
        serverChannel.accept(this, new AcceptCompleteHandler());
    }
}
