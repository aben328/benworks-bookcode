package benworks.netty.in.action.embedded;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * @author Ben
 * @date 2015年10月16日下午5:24:58
 */
public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {

	@Override
	protected void encode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		while (msg.readableBytes() >= 4) {
			int value = Math.abs(msg.readInt());
			out.add(value);
		}
	}

}
