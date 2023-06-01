package ru.nsu.fit.vinter.chat.client.core;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class ClientNetworkCommunication {
    private SocketChannel socketChannel;
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 8189;

    public ClientNetworkCommunication(Callback onMessageReceivedCallback) {

        Thread t = new Thread( () -> {
            //handling network events
            EventLoopGroup networkCommunicationGroup = new NioEventLoopGroup();
            try {
                Bootstrap clientChannel = new Bootstrap();
                clientChannel.group(networkCommunicationGroup)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                socketChannel = ch;
                                ch.pipeline().addLast(new StringDecoder(),
                                        new StringEncoder(),
                                        new ClientHandler(onMessageReceivedCallback));
                            }
                        });
                ChannelFuture future = clientChannel.connect(LOCALHOST, PORT).sync();
                //without creating new Thread this blocking operation will block out interface((
                future.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                networkCommunicationGroup.shutdownGracefully();
            }
        });
        t.setDaemon(true);
        t.start();
    }

    public void sendMessage(String str) {
        socketChannel.writeAndFlush(str);
    }

    public void close() {
        socketChannel.disconnect();
        socketChannel.close();
    }
}
