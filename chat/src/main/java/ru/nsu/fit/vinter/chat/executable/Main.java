package ru.nsu.fit.vinter.chat.executable;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Main {
    public static void main(String[] args) {
        // Обработка в параллельных потоках -- менеджеры потоков // пуллы потоков

        //подключение/инициализация клиентов клиентов
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        //обработка данных / сетевое взаимодействие
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap chatServer = new ServerBootstrap();
            chatServer.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //socket channel contains all data about connection
                        //we have initialized channel for connection
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {

                        }
                    });
            //привязываемся к порту и запускаем сервер
            ChannelFuture future = chatServer.bind(8189).sync();
            //blocking operation // we are waiting for server to be closed;
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //closing threadpools
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}