package benworks.netty.in.action.coder;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * @author Ben
 * @param <I>
 * @date 2015年10月14日下午8:59:47
 */
public class ByteArrayDecoder extends MessageToMessageDecoder<ByteBuf> {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		byte[] array = new byte[msg.readableBytes()];
		msg.getBytes(0, array);
		out.add(array);
	}

}
