package benworks.netty.in.action.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

/**
 * //netty3
 * @author Ben
 * @param <C>
 * @date 2015年10月15日上午10:39:50
 */
public class HttpDecoderEncoderInitializer extends ChannelInitializer<Channel> {

	private final boolean client;

	public HttpDecoderEncoderInitializer(boolean client) {
		this.client = client;
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		if (client) {
			// pipeline.addLast("decoder", new HttpResponseDecoder());
			// pipeline.addLast("decoder", new HttpRequestEncoder());
		} else {
			// pipeline.addLast("decoder", new HttpRequestDecoder());
			// pipeline.addLast("decoder", new HttpResponseEncoder()); 
		}
	}

}
