package benworks.netty.in.action.bootstrap;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.oio.OioDatagramChannel;

/**
 * 引导也可以用于无连接的传输协议如UDP，Netty提供了DatagramChannel，唯一的区别是不是connect(...)，只能是bind(...)
 * @author Ben
 * @date 2015年10月16日下午4:21:03
 */
public class DatagramChannelBootstap {

	public static void main(String[] args) {
		Bootstrap b = new Bootstrap();
		b.group(new OioEventLoopGroup()).channel(OioDatagramChannel.class)
				.handler(new SimpleChannelInboundHandler<DatagramPacket>() {
					@Override
					protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
						// do something with the packet...
					}
				});

		// 不是connect(...)，只能是bind(...)
		ChannelFuture future = b.bind(new InetSocketAddress(0));

		future.addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				if (future.isSuccess()) {
					System.out.println("Channel bound!~");
				} else {
					System.out.println("Bound attempt failed!");
					future.cause().printStackTrace();
				}
			}
		});
	}
}
