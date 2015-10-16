package benworks.netty.in.action.bootstrap;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

/**
 * 通过使用属性，应用程序能在通道存储用户Id以确定消息应该发送到哪里
 * @author Ben
 * @date 2015年10月16日下午4:10:05
 */
public class WebSocketAttrClient {

	public static void main(String[] args) {
		// 创建属性键对象
		final AttributeKey<Integer> id = AttributeKey.valueOf("ID");
		// 客户端引导对象
		Bootstrap b = new Bootstrap();
		// 设置EventLoop,设置通道类型
		b.group(new NioEventLoopGroup()).channel(NioSocketChannel.class)
				.handler(new SimpleChannelInboundHandler<ByteBuf>() {

					@Override
					protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
						System.out.println("Received data");
						msg.clear();
					}

					@Override
					public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
						// 通道注册后执行，获得属性值
						Integer idValue = ctx.channel().attr(id).get();

						System.out.println(idValue);

						// do something with the idValue...
					}
				});

		// 设置通道选项,在通道注册后或被创建后设置，在给定的时间内（5000）没有收到消息将自动断开连接
		b.option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
		// 设置通道属性值
		b.attr(id, 123456);

		ChannelFuture future = b.connect("www.baidu.com", 80);
		future.syncUninterruptibly();

	}
}
