package ru.nsu.fit.vinter.chat.server.core;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Handler for incoming data
public class ServerMainHandler extends SimpleChannelInboundHandler<String> {
    private static final List<Channel> clientsList = new ArrayList<>();
    private String clientName;
    private static int newClientIndex = 1;
    private boolean isNamed = false;

    //when client has connected
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client has connected :: " + ctx);
        clientsList.add(ctx.channel());
        clientName = "Client #" + newClientIndex;
        newClientIndex++;
    }

    //when client has disconnected
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client has disconnected ::" + ctx);
        broadcastMessage("SERVER", clientName + " has disconnected");
    }

    //when server has got message
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        if (Objects.equals(clientName, "")) {
            return;
        }
        System.out.println("Got message:: " + msg);
        if (msg.startsWith("/")) {
            if (msg.startsWith("/setname") && !isNamed) {
                clientName = msg.split("\\s", 2)[1];
                broadcastMessage("SERVER", "New client has connected " + clientName);
                isNamed = true;
            }
            if (msg.startsWith("/changename")) {
                String oldName = clientName;
                clientName = msg.split("\\s", 2)[1];
                if (Objects.equals(clientName, "")) {
                    clientName = oldName;
                    return;
                }
                broadcastMessage("SERVER", oldName + " has changed name to " + clientName);
            }
        } else {
            broadcastMessage(clientName, msg);
        }
    }

    public void broadcastMessage(String clientName, String msg) {
        //[ClientName]: <his message> \n
        String out = String.format("[%s]: %s\n", clientName, msg);
        for (Channel ch : clientsList) {
            ch.writeAndFlush(out);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Client " + clientName + "got disconnected");
        clientsList.remove(ctx.channel());
        broadcastMessage("SERVER", "Client has disconnected " + clientName);
        cause.printStackTrace();
        ctx.close();
    }
}
