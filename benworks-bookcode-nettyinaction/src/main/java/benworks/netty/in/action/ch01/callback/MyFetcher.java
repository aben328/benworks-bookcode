package benworks.netty.in.action.ch01.callback;

/**
 * @author Ben
 * @date 2015年10月13日下午2:37:54
 */
public class MyFetcher implements Fetcher {

	final Data data;

	public MyFetcher(Data data) {
		this.data = data;
	}

	@Override
	public void fetchDate(FetcherCallback callback) {
		try {
			callback.onData(data);
		} catch (Exception e) {
			callback.onError(e);
		}
	}

}
