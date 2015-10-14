package benworks.netty.in.action.channel;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 请注意：如果ChannelHandler实例如果带有@sharable注解则可以被添加到多个ChannelPipeline。也就是说单个ChannelHandler<br>
 * 实例可以有多个ChannelHandlerContext ，因此可以调用 不同的ChannelHandlerContext 获得同一个ChannelHandler，<br>
 * 如果添加不带@Sharable注解的ChannelHandler实例到多个ChannelPipeline则会报异常，使用@Sharable注解后必须在不同的线程<br>
 * 和不同的 通道上安全使用
 * @author Ben
 * @date 2015年10月14日下午2:17:16
 */
@Sharable
public class NotSharableHandler extends ChannelInboundHandlerAdapter {

	private int count;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		super.channelRead(ctx, msg);
		// 使用@Sharable注解后的Handler，它会被多个线程使用，里面的count是不安全的，会导致 count值错误
		System.out.println("channelRead(...) called the " + count + "time");
		// TODO
		ctx.fireChannelRead(msg);
	}
}
