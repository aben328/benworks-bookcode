package benworks.netty.in.action.buffers;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author Ben
 * @date 2015年10月14日上午10:10:10
 */
public class DirectBufferTest {

	public static void main(String[] args) {
		ByteBuf directBuf = Unpooled.directBuffer(16);
		if (!directBuf.hasArray()) {
			int len = directBuf.readableBytes();
			byte[] arr = new byte[len];
			directBuf.getBytes(0, arr);
		}
	}

}
