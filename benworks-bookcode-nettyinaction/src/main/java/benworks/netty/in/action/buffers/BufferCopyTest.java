package benworks.netty.in.action.buffers;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @author Ben
 * @date 2015年10月14日上午11:06:36
 */
public class BufferCopyTest {

	public static void main(String[] args) {
		Charset utf8 = Charset.forName("UTF-8");

		ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks", utf8);

		ByteBuf sliced = buf.slice(0, 14);

		ByteBuf copy = buf.copy(0, 14);

		//Netty in Action rocks
		System.out.println(buf.toString(utf8));

		//print Netty in Actio
		System.out.println(sliced.toString(utf8));

		//print Netty in Actio
		System.out.println(copy.toString(utf8));

	}
}
