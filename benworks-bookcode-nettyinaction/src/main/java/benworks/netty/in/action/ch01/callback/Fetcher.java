package benworks.netty.in.action.ch01.callback;

/**
 * @author Ben
 * @date 2015年10月13日下午2:30:19
 */
public interface Fetcher {

	void fetchDate(FetcherCallback callback);

}
