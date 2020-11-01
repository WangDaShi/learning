package com.loatr.learning.aio;

import java.awt.image.PackedColorModel;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadCompleteHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public ReadCompleteHandler(AsynchronousSocketChannel channel){
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        // 已经拿到了数据
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        channel.write(writeBuffer, writeBuffer, new CompletionHandler<>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                // 如果没有写完就继续写
                if(attachment.hasRemaining()){
                    channel.write(attachment,attachment,this);
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
