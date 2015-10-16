package benworks.netty.in.action.embedded;

import junit.framework.Assert;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.TooLongFrameException;

import org.junit.Test;

/**
 * 测试FrameChunkDecoder
 * @author Ben
 * @date 2015年10月16日下午6:02:28
 */
public class FrameChunkDecoderTest {

	@Test
	public void testFrameChunkDecoder() {
		ByteBuf buf = Unpooled.buffer();
		for (int i = 0; i < 9; i++) {
			buf.writeByte(i);// 0,1,2,3,4,5,6,7,8
		}

		ByteBuf input = buf.duplicate();

		EmbeddedChannel channel = new EmbeddedChannel(new FrameChunkDecoder(3));

		Assert.assertTrue(channel.writeInbound(input.readBytes(2)));
		try {
			// 读取4个字节写入入站通道
			channel.writeInbound(input.readBytes(4));
			Assert.fail();
		} catch (TooLongFrameException e) {

		}

		// 读取3个字节写入入站通道
		Assert.assertTrue(channel.writeInbound(input.readBytes(3)));
		// 标识完成
		Assert.assertTrue(channel.finish());

		// 从EmbeddedChannel读取入站数据
		Assert.assertEquals(buf.readBytes(2), channel.readInbound());
		Assert.assertEquals(buf.skipBytes(4).readBytes(3), channel.readInbound());
	}
}
