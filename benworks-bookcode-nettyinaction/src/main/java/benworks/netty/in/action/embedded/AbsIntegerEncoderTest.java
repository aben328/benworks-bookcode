package benworks.netty.in.action.embedded;

import junit.framework.Assert;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;

import org.junit.Test;

/**
 * @author Ben
 * @date 2015年10月16日下午5:27:40
 */
public class AbsIntegerEncoderTest {

	@Test
	public void testEncoded() {
		// 创建能容纳10个int的bytebuf
		ByteBuf buf = Unpooled.buffer();
		for (int i = 1; i < 10; i++) {
			buf.writeInt(i * -1);
		}

		// 创建EmbeddedChannel对象
		EmbeddedChannel channel = new EmbeddedChannel(new AbsIntegerEncoder());
		// 将buf数据写入出站EmbeddedChannel
		Assert.assertTrue(channel.writeOutbound(buf));
		// 标示EmbeddedChanne完成
		Assert.assertTrue(channel.finish());
		// 读取出站数据
		ByteBuf outputBuf = (ByteBuf) channel.readOutbound();
		for (int i = 0; i < 10; i++) {
			Assert.assertEquals(i, outputBuf.readInt());
		}
		Assert.assertFalse(outputBuf.isReadable());
		Assert.assertNull(channel.readOutbound());
	}
}
