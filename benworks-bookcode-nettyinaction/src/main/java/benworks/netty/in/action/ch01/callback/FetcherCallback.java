package benworks.netty.in.action.ch01.callback;

/**
 * 回调技术是异步处理的一种方法，回调过程有个问题就是当你使用链式调用，很多不同的方法会导致线性代码，有些人认为这种链式调用会导致代码难以阅读，
 * 但是我认为这是一种风格问题，比如JavaScriptr Node.js越来越受到欢迎！
 * 
 * @author Ben
 * @date 2015年10月13日下午2:31:56
 */
public interface FetcherCallback {

	void onData(Data data) throws Exception;

	void onError(Throwable cause);

}
