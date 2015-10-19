package net.jcip.examples;

import java.util.concurrent.*;

/**
 * InterruptBorrowedThread
 * <p/>
 * Scheduling an interrupt on a borrowed thread
 * @author Brian Goetz and Tim Peierls
 */
public class TimedRun1 {
	private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(1);

	// 由于timeRun可以从任意一个线程中调用，因此它无法知道这个调用线程的中断策略。
	public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
		final Thread taskThread = Thread.currentThread();
		cancelExec.schedule(new Runnable() {
			public void run() {
				taskThread.interrupt();
			}
		}, timeout, unit);
		r.run();
	}
}
