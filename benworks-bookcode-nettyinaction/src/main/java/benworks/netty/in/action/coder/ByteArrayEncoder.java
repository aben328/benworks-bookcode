package benworks.netty.in.action.coder;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * @author Ben
 * @date 2015年10月14日下午9:01:37
 */
@Sharable
public class ByteArrayEncoder extends MessageToMessageEncoder<byte[]> {

	@Override
	protected void encode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
		out.add(Unpooled.wrappedBuffer(msg));
	}

}
