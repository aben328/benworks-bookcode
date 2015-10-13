package benworks.netty.in.action.ch01.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future是一个抽象的概念，它表是一个值，该值可能在某一个点变得可以用。一个Futrure要么获得计算完的结果，要么获得计算失败的异常。
 * 
 * @author Ben
 * @date 2015年10月13日下午2:53:54
 */
public class FutureExample {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();
		Runnable task1 = new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("i am task1......");
					Thread.sleep(5000);
					System.out.println("task1 is completed");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Callable<Integer> task2 = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				try {
					System.out.println("i am task2......");
					Thread.sleep(6000);
					System.out.println("task2 is completed");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return new Integer(100);
			}
		};

		Future<?> f1 = executor.submit(task1);
		Future<Integer> f2 = executor.submit(task2);

		// waiting task1 completed
		while (!f1.isDone()) {
			break;
		}
		System.out.println("task1 completed");
		
		// waiting task2 completed

		while (!f2.isDone()) {
		}
		
		System.out.println("return value by task2: " + f2.get());
	}

}
