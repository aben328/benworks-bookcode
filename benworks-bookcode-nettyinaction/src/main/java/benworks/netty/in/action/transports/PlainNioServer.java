package benworks.netty.in.action.transports;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Asynchronous networking without netty!
 * @author Ben
 * @date 2015年10月13日下午7:41:16
 */
public class PlainNioServer {

	public void serve(int port) throws IOException {
		System.out.println("Listening for connections on port " + port);
		ServerSocketChannel serverChannel;
		Selector selector;
		serverChannel = ServerSocketChannel.open();
		ServerSocket ss = serverChannel.socket();
		InetSocketAddress address = new InetSocketAddress(port);
		ss.bind(address);
		serverChannel.configureBlocking(false);
		selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
		while (true) {
			try {
				selector.select();
			} catch (IOException ex) {
				ex.printStackTrace();
				// handle in a proper way
				break;
			}
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				iterator.remove();
				try {
					if (key.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						SocketChannel client = server.accept();
						System.out.println("Accepted connection from " + client);
						client.configureBlocking(false);
						client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
					}
					if (key.isWritable()) {
						SocketChannel client = (SocketChannel) key.channel();
						ByteBuffer buffer = (ByteBuffer) key.attachment();
						while (buffer.hasRemaining()) {
							if (client.write(buffer) == 0) {
								break;
							}
						}
						client.close();
					}
				} catch (IOException ex) {
					key.cancel();
					try {
						key.channel().close();
					} catch (IOException cex) {
					}
				}
			}
		}
	}
}