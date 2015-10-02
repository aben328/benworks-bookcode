package c8;

// : IceCream.java
// Returning arrays from methods
/**
 * 注意当flavorSet()随机挑选香料的时候，它需要保证以前出现过的一次随机选择不会再次出现。为达到这个目的， 它使用了一个无限while循环，不断地作出随机选择，直到发现未在picks数组里出现过的一个元素为止（当然，
 * 也可以进行字串比较，检查随机选择是否在results数组里出现过，但字串比较的效率比较低）。
 * @author Ben
 */
public class IceCream {
	static String[] flav = { "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge",
		"Rum Raisin", "Praline Cream", "Mud Pie" };

	static String[] flavorSet(int n) {
		// Force it to be positive & within bounds:
		n = Math.abs(n) % (flav.length + 1);
		String[] results = new String[n];
		int[] picks = new int[n];
		for (int i = 0; i < picks.length; i++)
			picks[i] = -1;
		for (int i = 0; i < picks.length; i++) {
			retry:
			while (true) {
				int t = (int) (Math.random() * flav.length);
				for (int j = 0; j < i; j++)
					if (picks[j] == t)
						continue retry;
				picks[i] = t;
				results[i] = flav[t];
				break;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println("flavorSet(" + i + ") = ");
			String[] fl = flavorSet(flav.length);
			for (int j = 0; j < fl.length; j++)
				System.out.println("\t" + fl[j]);
		}
	}
} // /:~
