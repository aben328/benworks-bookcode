package benworks.netty.in.action.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * 实现ChannelInboundHandlerAdapter 的Handler，不会自动释放接收到的消息对象
 * @author Ben
 * @date 2015年10月14日下午2:55:25
 */
public class DiscardHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// 需要手动释放
		ReferenceCountUtil.release(msg);
	}
}
