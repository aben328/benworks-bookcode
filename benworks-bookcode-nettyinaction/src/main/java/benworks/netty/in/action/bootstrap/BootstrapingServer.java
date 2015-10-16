package benworks.netty.in.action.bootstrap;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 1.boosGroup,workerGroup <br>
 * 2.NioServerSocketChannel <br>
 * 3.childHandler <br>
 * 4.b.bind(2048);<br>
 * @author Ben
 * @date 2015年10月16日下午2:52:47
 */
public class BootstrapingServer {
	public static void main(String[] args) {
		EventLoopGroup boosGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		ServerBootstrap b = new ServerBootstrap();
		b.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class)
				.childHandler(new SimpleChannelInboundHandler<ByteBuf>() {// childHandler
							@Override
							protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
								System.out.println("received data!");
								msg.clear();
							}
						});

		ChannelFuture f = b.bind(2048);

		f.addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				if (future.isSuccess()) {
					System.out.println("Server bound!");
				} else {
					System.err.println("bound fail");
					future.cause().printStackTrace();
				}
			}
		});
	}
}
