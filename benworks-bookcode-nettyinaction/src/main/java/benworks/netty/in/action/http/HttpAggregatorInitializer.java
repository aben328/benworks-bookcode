package benworks.netty.in.action.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

/**
 * @author Ben
 * @date 2015年10月15日下午5:52:17
 */
public class HttpAggregatorInitializer extends ChannelInitializer<Channel> {

	private final boolean client;

	public HttpAggregatorInitializer(boolean client) {
		this.client = client;
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		if (client) {
//			 pipeline.addLast("decoder", new HttpClientCodec());
		} else {
			// pipeline.addLast("decoder", new HttpRequestDecoder());
		}
	}

}
