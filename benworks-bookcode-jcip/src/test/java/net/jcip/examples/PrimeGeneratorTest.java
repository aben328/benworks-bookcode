package net.jcip.examples;

import java.math.BigInteger;
import java.util.List;

public class PrimeGeneratorTest {

	public static void main(String[] args) throws InterruptedException {
		List<BigInteger> list = PrimeGenerator.aSecondOfPrimes();
		for (BigInteger big : list) {
			System.out.println(big);
		}
	}
}
