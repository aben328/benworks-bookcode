package benworks.netty.in.action.transports;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Implementing asynchronous support<br>
 * Ne
 * @author Ben
 * @date 2015年10月13日下午7:43:41
 */
public class NettyNioServer {

	public void server(int port) throws Exception {
		final ByteBuf buf = Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8"));
		// 事件循环组
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			// 使用引导服务器配置
			ServerBootstrap b = new ServerBootstrap();
			// 使用异步模式
			b.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
			// 指定ChannelInitializer初始化Handers
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							// 添加一个“入站”handler到ChannelPipeline
							ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
								@Override
								public void channelActive(ChannelHandlerContext ctx) throws Exception {
									// 连接后，写消息 到客户端，写完便关闭连接
									ctx.write(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
								}
							});
						}
					});
			// 绑定服务器接受连接
			ChannelFuture f = b.bind().sync();
			f.channel().closeFuture().sync();
		} finally {
			// 释放所有资源
			group.shutdownGracefully().sync();
		}
	}
}
