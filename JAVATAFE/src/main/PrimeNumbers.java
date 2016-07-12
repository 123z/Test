package main;

public class PrimeNumbers {

	public static void main(String[] args0) {
		PrimeNumbers primeNumbers = new PrimeNumbers();
		primeNumbers.findPrimeNumbers(15000);
	}

	public void findPrimeNumbers(int max) {
		for (int i = 1; i < max; i++) {
			int counter = 0;
			int num = i;
			while(num >= 1) {
				if (i % num == 0) {
					counter = counter + 1;
				}
				num--;
			}
			if (counter == 2) {
				System.out.println(i + " ");
			}
		}
	}
}
