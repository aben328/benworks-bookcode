package benworks.netty.in.action.bootstrap;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import benworks.netty.in.action.coder.HttpClientCodec;
import benworks.netty.in.action.http.HttpObjectAggregator;

/**
 * 使用ChannelInitializer初始化ChannelHandler
 * @author Ben
 * @date 2015年10月16日下午3:54:13
 */
public class InitChannelExample {

	public static void main(String[] args) throws Exception {
		EventLoopGroup boosGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		ServerBootstrap b = new ServerBootstrap();
		b.group(boosGroup, workerGroup).channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializerImpl());

		ChannelFuture f = b.bind(2048).sync();

		f.channel().closeFuture().sync();
	}

	static final class ChannelInitializerImpl extends ChannelInitializer<Channel> {
		@Override
		protected void initChannel(Channel ch) throws Exception {
			ch.pipeline().addLast(new HttpClientCodec()).addLast(new HttpObjectAggregator(Integer.MAX_VALUE));
		}
	}
}
