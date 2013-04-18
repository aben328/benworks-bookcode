/**
 * 
 */
package benworks.bookcode.jcip.c10;

import javax.naming.InsufficientResourcesException;

/**
 * @author Ben
 * 
 */
public class Demo10_3 {
	private static final Object tieLock = new Object();

	public void transferMoney(final Account fromAcct, final Account toAcct,
			final DollarAmount amount) {

		class Helper {
			public void transfer() throws InsufficientResourcesException {
//				if (fromAcct.getBalance().compareTo(amount) < 0) {
//					throw new InsufficientResourcesException();
//				} else {
//					fromAcct.debit(amount);
//					toAcct.credit(amount);
//				}
			}
		}
		
		int fromHash = System.identityHashCode(fromAcct);
		int toHash = System.identityHashCode(toAcct);

	}

}
