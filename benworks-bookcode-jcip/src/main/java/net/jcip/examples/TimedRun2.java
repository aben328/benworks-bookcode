package net.jcip.examples;

import java.util.concurrent.*;
import static java.util.concurrent.Executors.newScheduledThreadPool;
import static net.jcip.examples.LaunderThrowable.launderThrowable;

/**
 * TimedRun2
 * <p/>
 * Interrupting a task in a dedicated thread
 * @author Brian Goetz and Tim Peierls
 */
public class TimedRun2 {
	private static final ScheduledExecutorService cancelExec = newScheduledThreadPool(1);

	public static void timedRun(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
		class RethrowableTask implements Runnable {
			private volatile Throwable t;// 由于t将在两个线程（taskThread,task)之间共享，所有声明为volatile类型

			public void run() {
				try {
					r.run();
				} catch (Throwable t) {
					this.t = t;
				}
			}

			void rethrow() {
				if (t != null)
					throw launderThrowable(t);
			}
		}

		RethrowableTask task = new RethrowableTask();
		final Thread taskThread = new Thread(task);
		taskThread.start();
		cancelExec.schedule(new Runnable() {
			public void run() {
				taskThread.interrupt();
			}
		}, timeout, unit);
		taskThread.join(unit.toMillis(timeout));// 依赖一个限时的join，因此存在着join的不足
		task.rethrow();
	}
}
