package benworks.netty.in.action.ssl;

import javax.net.ssl.SSLEngine;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

/**
 * @author Ben
 * @date 2015年10月15日上午10:10:10
 */
public class SslChannelInitializer extends ChannelInitializer<Channel> {
	private final SslContext context;
	private final boolean client;
	private final boolean startTls;

	public SslChannelInitializer(SslContext context, boolean client, boolean startTls) {
		this.context = context;
		this.client = client;
		this.startTls = startTls;
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		SSLEngine engine = context.newEngine(ch.alloc());
		// SSLEngine engine = context.createSslEngine();//netty5.0
		engine.setUseClientMode(client);
		ch.pipeline().addFirst("ssl", new SslHandler(engine, startTls));
	}

}
