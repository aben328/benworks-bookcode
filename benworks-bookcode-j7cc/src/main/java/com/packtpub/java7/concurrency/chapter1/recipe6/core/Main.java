package com.packtpub.java7.concurrency.chapter1.recipe6.core;

import java.util.Date;

import com.packtpub.java7.concurrency.chapter1.recipe6.task.DataSourcesLoader;
import com.packtpub.java7.concurrency.chapter1.recipe6.task.NetworkConnectionsLoader;

/**
 * Main class of the Example. Create and start two initialization tasks and wait for their finish <br>
 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。<br>
 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。<br>
 */
public class Main {

	/**
	 * Main method of the class. Create and star two initialization tasks and wait for their finish
	 * @param args
	 */
	public static void main(String[] args) {

		// Creates and starts a DataSourceLoader runnable object
		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader, "DataSourceThread");
		thread1.start();

		// Creates and starts a NetworkConnectionsLoader runnable object
		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");
		thread2.start();

		// Wait for the finalization of the two threads
		try {
			// 将线程1，线程2加入到Main主线程
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Waits a message，执行完线程1，2，才会执行当以下语句
		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
	}
}
