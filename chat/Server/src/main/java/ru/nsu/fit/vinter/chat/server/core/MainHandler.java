package ru.nsu.fit.vinter.chat.server.core;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

// Handler for incoming data
public class MainHandler extends SimpleChannelInboundHandler<String> {
    private static final List<Channel> clients = new ArrayList<>();
    private String clientName;
    private static int newClientIndex = 1;

    //when client connected
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client has been connected :: " + ctx);
        clients.add(ctx.channel());
        clientName = "Client #" + newClientIndex;
        newClientIndex++;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client has been disconnected");
    }

    //when client sent message
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("Got message:: " + msg);
        //[ClientName]: <his message> \n
        String out = String.format("[%s]: %s\n", clientName, msg);
        for (Channel ch : clients) {
            ch.writeAndFlush(out);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
