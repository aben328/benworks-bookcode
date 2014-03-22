package benworks.bookcode.demo.forkjoin;

import org.junit.Test;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;


public class Test {

	@Test
	public void run() throws Exception {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Future<Integer> result = forkJoinPool.submit(new Calculator(0, 10000));

		assertEquals(new Integer(49995000), result.get());
	}

}
