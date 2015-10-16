package benworks.netty.in.action.bootstrap;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 1.boosGroup,workerGroup <br>
 * 2.NioServerSocketChannel <br>
 * 3.childHandler <br>
 * 4.b.bind(2048);
 * @author Ben
 * @date 2015年10月16日下午2:52:47
 */
public class BootstrapingFromChannel {

	public static void main(String[] args) {
		EventLoopGroup boosGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		ServerBootstrap b = new ServerBootstrap();
		b.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class)
				.childHandler(new SimpleChannelInboundHandler<ByteBuf>() {// childHandler
							ChannelFuture connectFuture;

							@Override
							public void channelActive(ChannelHandlerContext ctx) throws Exception {
								Bootstrap b = new Bootstrap();
								b.channel(NioSocketChannel.class).handler(new SimpleChannelInboundHandler<ByteBuf>() {
									@Override
									protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg)
											throws Exception {
										System.out.println("Received data");
										msg.clear();
									}
								});
								// 子线程和父线程共享同一个EventLoop，同一个EventLoop同一个线程执行，
								// 共享EventLoop可以确定所有的Channel都分配给同一个线程的EventLoop，
								// 这样就避免了不同的线程之间切换上下文，从而减少资源开销
								b.group(ctx.channel().eventLoop());

								connectFuture = b.connect(new InetSocketAddress("127.0.0.1", 2048));
							}

							@Override
							protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
								// do something with the data
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
