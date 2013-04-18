package benworks.bookcode.jcip.c10;

import java.util.Random;

public class Demo10_4 {
	private static final int NUM_THREADS = 20;
	private static final int NUM_ACCOUNTS = 5;
	private static final int NUM_ITERATIONS = 1000000;

	public static void main(String[] args) {
		final Random rnd = new Random();
		final Account[] accounts = new Account[NUM_ACCOUNTS];

		for (Account account : accounts) {
			account = new Account();
		}
		for (int i = 0; i < NUM_THREADS; i++) {
			 //must after TransferThread
			// class declared.
			// new TransferThread().start();
		}
		class TransferThread extends Thread {
			public void run() {
				for (int i = 0; i < NUM_ITERATIONS; i++) {
					int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
					int toAcct = rnd.nextInt(NUM_ACCOUNTS);
					DollarAmount amount = new DollarAmount(rnd.nextInt(1000));
					transferMoney(accounts[fromAcct], accounts[toAcct], amount);
				}
			}

			private void transferMoney(Account account, Account account2,
					DollarAmount amount) {

			}
		}
		
		for (int i = 0; i < NUM_THREADS; i++) {
			new TransferThread().start();
		}
	}
}
