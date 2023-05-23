package ru.nsu.fit.vinter.chat.client.core;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class Network {
    private SocketChannel socketChannel;
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 8189;

    private Callback onMessageReceivedCallback;

    public Network(Callback onMessageReceivedCallback) {
        this.onMessageReceivedCallback = onMessageReceivedCallback;

        new Thread( () -> {
            //handling network events
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(workerGroup)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                socketChannel = ch;
                                //default String-Handler for handling string & bytebuffer
                                ch.pipeline().addLast(new StringDecoder(),
                                        new StringEncoder(),
                                        new SimpleChannelInboundHandler<String>() {
                                            @Override
                                            protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                                                if (onMessageReceivedCallback != null) {
                                                    onMessageReceivedCallback.callback(msg);
                                                }
                                            }
                                        });
                            }
                        });
                ChannelFuture future = bootstrap.connect(LOCALHOST, PORT).sync();
                //without creating new Thread this blocking operation will block out interface((
                future.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                workerGroup.shutdownGracefully();
            }
        }).start();
    }

    public void sendMessage(String str) {
        socketChannel.writeAndFlush(str);
    }
}
