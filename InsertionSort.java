package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public class InsertionSort extends Sort{
	
	// Store benchmark results
	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	String sortName = "InsertionSort\t";

	public InsertionSort() {
	}
	
	// Times the running of the sorting algorithm
	public double timer(Sort i, int[] array) {
		long startTime = System.nanoTime();							
		this.insertionSort(array);								//Run the sorting algorithm on the array
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (Double) elapsedMillis;
	}
	
	
	/*
	 *  Starting on the left compare each element with the one to its left.
	 *  If the element is larger than the left we swap these two elements
	 *   and continue working to the left comparing until the element to the left is smaller than the current element.
 	 */
	private void insertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;						//At beginning j = 0

			while (j > 0 && array[j] > temp) {	// While not at the leftmost element and the element at array[j] is larger than the element at temp
				array[j + 1] = array[j]; 		// Swap elements at j and j+1
				array[j--] = temp;				// Move leftwards along the array
			}
		}
	}
	
	
	@Override
	public String toString () {
		return this.sortName;
	}


	

}
