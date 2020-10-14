package com.loatr.learning;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleTest {

    private static ObjectMapper jsonMapper = new ObjectMapper();
    private static ExecutorService executor = Executors.newSingleThreadExecutor();
    private static ExecutorService executor2 = Executors.newSingleThreadExecutor();

    private static ByteBuffer readBuffer = ByteBuffer.allocate(512);
    private static ByteBuffer writeBuffer = ByteBuffer.allocate(512);

    public static void main(String[] args){
//        SocketClientTest client = new SocketClientTest();
//        new Thread(()->client.startClient()).start();
        test();
    }

    public static void test(){
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress("127.0.0.1",8081));
            ssc.configureBlocking(false);
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                int available = selector.select();
                if(available == 0){
                    continue;
                }
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if(key.isAcceptable()){
                        SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ);
                    }else if(key.isReadable()){
                        read((SocketChannel)key.channel());
                        key.interestOps(SelectionKey.OP_WRITE);
                    }else if(key.isWritable()){
                        write((SocketChannel)key.channel());
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("通讯终端，message:" + e.getMessage());
        }
    }

    private static void read(SocketChannel channel) throws IOException {
        readBuffer.clear();
        channel.read(readBuffer);
        readBuffer.flip();
        System.out.println("server received message:" + new String(readBuffer.array()));
    }

    private static void write(SocketChannel channel) throws IOException {
        writeBuffer.clear();
        writeBuffer.put("this is a reply".getBytes());
        writeBuffer.flip();
        channel.write(writeBuffer);
    }
}
