package benworks.bookcode.jtis.chapter5;

import java.nio.channels.SelectionKey;
import java.io.IOException;

public interface TCPProtocol {
	/**
	 * @param key
	 * @throws IOException
	 */
	void handleAccept(SelectionKey key) throws IOException;

	/**
	 * @param key
	 * @throws IOException
	 */
	void handleRead(SelectionKey key) throws IOException;

	/**
	 * @param key
	 * @throws IOException
	 */
	void handleWrite(SelectionKey key) throws IOException;
}