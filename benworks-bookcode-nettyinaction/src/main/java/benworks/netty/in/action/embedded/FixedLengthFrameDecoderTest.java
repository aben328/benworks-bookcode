package benworks.netty.in.action.embedded;

import junit.framework.Assert;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;

import org.junit.Test;

/**
 * @author Ben
 * @date 2015年10月16日下午4:45:06
 */
public class FixedLengthFrameDecoderTest {

	@Test
	public void testFrameDecoded() {
		ByteBuf buf = Unpooled.buffer();
		for (int i = 0; i < 9; i++) {
			buf.writeByte(i);// 0,1,2,3,4,5,6,7,8
		}

		ByteBuf input = buf.duplicate();

		EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

		// write bytes

		Assert.assertTrue(channel.writeInbound(input));
		Assert.assertTrue(channel.finish());

		// read message
		Assert.assertEquals(buf.readBytes(3), channel.readInbound());
		Assert.assertEquals(buf.readBytes(3), channel.readInbound());
		Assert.assertEquals(buf.readBytes(3), channel.readInbound());

		Assert.assertNull(channel.readInbound());

	}

	@Test
	public void testFrameDecoded2() {
		ByteBuf buf = Unpooled.buffer();
		for (int i = 0; i < 9; i++) {
			buf.writeByte(i);
		}

		ByteBuf input = buf.duplicate();

		EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

		// write bytes

		Assert.assertFalse(channel.writeInbound(input.readBytes(2)));
		Assert.assertTrue(channel.writeInbound(input.readBytes(7)));
		Assert.assertTrue(channel.finish());

		// read message
		Assert.assertEquals(buf.readBytes(3), channel.readInbound());
		Assert.assertEquals(buf.readBytes(3), channel.readInbound());
		Assert.assertEquals(buf.readBytes(3), channel.readInbound());

		Assert.assertNull(channel.readInbound());

	}
}
