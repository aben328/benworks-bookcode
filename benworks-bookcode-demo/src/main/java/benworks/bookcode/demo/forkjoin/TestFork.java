package benworks.bookcode.demo.forkjoin;

import static org.junit.Assert.*;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import org.junit.Test;

public class TestFork {

	@Test
	public void run() throws Exception {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Future<Integer> result = forkJoinPool.submit(new Calculator(0, 10000));

		assertEquals(new Integer(49995000), result.get());
	}

}
