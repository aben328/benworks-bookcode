package benworks.netty.in.action.coder;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * 编码器：将Intger编译成String,MessageToMessageEncoder实现
 * @author Ben
 * @date 2015年10月14日下午8:55:46
 */
public class IntegerToStringEncoder extends MessageToMessageEncoder<Integer> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Integer msg, List<Object> out) throws Exception {
		ctx.write(String.valueOf(msg));
	}

}
