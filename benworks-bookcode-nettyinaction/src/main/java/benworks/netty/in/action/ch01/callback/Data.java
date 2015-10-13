package benworks.netty.in.action.ch01.callback;

/**
 * @author Ben
 * @date 2015年10月13日下午2:32:17
 */
public class Data {
	private int n;
	private int m;

	public Data(int n, int m) {
		super();
		this.n = n;
		this.m = m;
	}

	@Override
	public String toString() {
		int r = n / m;
		return n + "/" + m + "=" + r;
	}

}
