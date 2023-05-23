package ru.nsu.fit.vinter.chat.server.executable;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import ru.nsu.fit.vinter.chat.server.core.MainHandler;

public class ServerLaunch {
    private static final int PORT = 8189;

    public static void main(String[] args) {
        // Parallel processing -- threads managers // or simply thread-pools

        // Connection/initialization clients
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        // Processing data / network communication
        EventLoopGroup workerGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap chatServer = new ServerBootstrap();
            chatServer.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // socket channel contains all data about connection
                        // we have to initialized channel for connection
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //adding new handler to pipeline (конвеер)
                            socketChannel.pipeline().addLast(new StringDecoder(),
                                                            new StringEncoder(),
                                                            new MainHandler());
                        }
                    });
            //bind to process and launch a server
            ChannelFuture future = chatServer.bind(PORT).sync();
            //blocking operation / we are waiting for server to be closed;
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //closing thread-pools
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}