package benworks.netty.in.action.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器：将Intger编译成byte[]
 * @author Ben
 * @param <I>
 * @date 2015年10月14日下午8:51:58
 */
public class IntegerToByteEncoder extends MessageToByteEncoder<Integer> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Integer msg, ByteBuf out) throws Exception {
		out.writeInt(msg);
	}	

}
