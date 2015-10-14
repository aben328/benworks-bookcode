package benworks.netty.in.action.buffers;

import java.util.Iterator;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author Ben
 * @date 2015年10月14日上午10:28:22
 */
public class CompositeByteBufTest {
	public static void main(String[] args) {
		CompositeByteBuf compBuf = Unpooled.compositeBuffer();
		ByteBuf heapBuf = Unpooled.buffer(8);
		ByteBuf directBuf = Unpooled.directBuffer(16);

		// 添加ByteBuf到CompositeByteBuf
		compBuf.addComponents(heapBuf, directBuf);
		// 删除第一个ByteBuf
		compBuf.removeComponent(0);

		Iterator<ByteBuf> iter = compBuf.iterator();
		while (iter.hasNext()) {
			ByteBuf byteBuf = (ByteBuf) iter.next();
			System.out.println(byteBuf.toString());
		}
		// 使用数组访问数据
		if (!compBuf.hasArray()) {
			int len = compBuf.readableBytes();
			byte[] arr = new byte[len];
			compBuf.getBytes(0, arr);
		}
	}
}
