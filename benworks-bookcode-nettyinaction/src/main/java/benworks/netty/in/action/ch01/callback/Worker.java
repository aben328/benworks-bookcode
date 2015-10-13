package benworks.netty.in.action.ch01.callback;

/**
 * 
 * @author Ben
 * @date 2015年10月13日下午2:28:46
 */
public class Worker {

	public void doWork() {
		Fetcher fetcher = new MyFetcher(new Data(10, 2));
		fetcher.fetchDate(new FetcherCallback() {

			@Override
			public void onData(Data data) throws Exception {
				System.out.println("Data received:" + data);
			}

			@Override
			public void onError(Throwable cause) {
				System.err.println("An error accour:" + cause.getMessage());
			}

		});
	}

	public static void main(String[] args) {
		Worker w = new Worker();
		w.doWork();
	}

}
