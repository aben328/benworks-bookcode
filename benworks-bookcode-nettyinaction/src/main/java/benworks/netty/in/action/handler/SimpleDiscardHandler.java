package benworks.netty.in.action.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 继承SimpleChannelInboundHandler,会自动 释放消息对象
 * @author Ben
 * @date 2015年10月14日下午2:57:09
 */
public class SimpleDiscardHandler extends SimpleChannelInboundHandler<Object> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		// 不需要手动释放
	}
}
