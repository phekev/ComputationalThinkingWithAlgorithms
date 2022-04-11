package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CreateArrays {
	
	// Create an array of pseudorandom numbers in the range 0-1000
	public static int[] createRandomArray (int n) {
		int[] array = new int[n];
		for (int i=0; i<n; i++) {
			array[i] = (int) ThreadLocalRandom.current().nextInt(0, 1000);		
		}
		return array;
	}
	
	
	
	/*
	 *	Create a partially sort array of size n
	 *	1. Starting with a sorted array
	 *	2. Random indexes -/+ 2 of current index are swapped
	 *	3. Elements are moved at most 4 places from their sorted position
	 *
	 *	Example [0, 3, 6, 10, 12, 16, 18, 20, 23, 28]
	 *			[6, 3, 0, 10, 12, 16, 28, 20, 23, 18]
	 *			 X     X               Y           Y
	 */
		public static int[] partialSortedArray (int n) {		
		/*
		 * OFFSET 
		 * How far to move along the array in each iteration. 
		 * Moving 7 to avoid the possibility of elements getting 
		 * moved more than 4 spaces from where they should be.
		 */
		int offset = 7;			
		int[] partialSorted = createRandomArray(n);			//Create a randomly sorted array 
		Arrays.sort(partialSorted);							//Sort the array
		Random rand = new Random();
		
		int k = 2;

		/*
		 * Iterate over the array moving a distance of OFFSET each time.
		 */
		for (int i=0; i<partialSorted.length-1; i+=offset) {
			int lowIndex = i + rand.nextInt(-k, 0); 		//lowIndex is i, i-1 or i-2
			if (lowIndex < 0) 
				lowIndex = i;

			int highIndex = i + rand.nextInt(1, 1+k); 		//highIndex is i+1, i+2 or i+3
			if (highIndex >= partialSorted.length) 
				highIndex = i;

			//Swap the two selected elements
			int temp = partialSorted[lowIndex];
			partialSorted[lowIndex] = partialSorted[highIndex];
			partialSorted[highIndex] = temp;


		}
		return partialSorted;
	}


}
