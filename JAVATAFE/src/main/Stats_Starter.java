package main;

import java.util.Arrays;

/**
 * @author Mark
 */
public class Stats_Starter {

	public static void main(String[] args) {
		int myNumbers[] = {11, 11, 23, 67, 5, 16, 72, 33, 7, 88, 23 };
		CalcStats myStats = new CalcStats();
		myStats.printStats(myNumbers);
	}

}

class CalcStats {
	public void printStats(int values[]) {
		System.out.print("My Numbers: ");
		for (int count = 0; count < values.length; count++)
			System.out.print("" + values[count] + ", ");
		System.out.println("");

		System.out.println("Smallest: " + getSmallest(values));
		System.out.println("Largest: " + getLargest(values));
		System.out.println("Mean: " + getMean(values));
		System.out.println("Median: " + getMedian(values));
		System.out.println("Mode: " + getMode(values));

	}

	public int getSmallest(int values[]) {
		int smallest = values[0];
		for (int value = 0; value < values.length; value++) {
			if (smallest > values[value])
				smallest = values[value];
		}
		return smallest;
	}

	public int getLargest(int values[]) {
		int largest = values[0];
		for (int value = 0; value < values.length; value++) {
			if (largest < values[value])
				largest = values[value];
		}
		return largest;
	}

	public double getMean(int values[]) {
		double total = 0;
		for (int value = 0; value < values.length; value++) {
			total += values[value];
		}
		double mean = total / values.length;

		return mean;
	}

	public double getMedian(int values[]) {
		Arrays.sort(values);
		double median = values.length / 2;
		if (values.length % 2 == 0) {
			int v1 = values[((values.length - 1) / 2)];
			int v2 = values[((values.length - 1) / 2) + 1];

			median = (v1 + v2) / 2;
		} else {
			median = values[values.length / 2];
		}

		return median;
	}

	public int getMode(int values[]) {
		int mode = values[0];
		int maxCounts = 0;

		for (int i = 0; i < values.length; i++) {
			int value = values[i];
			int count = 0;
			for (int j = 0; j < values.length; j++) {
				if (values[j] == value) {
					count++;
				}

			}
			if (count > maxCounts) {
				mode = value;
				maxCounts = count;
			}

		}

		return mode;
	}

}
