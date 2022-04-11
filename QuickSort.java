package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public class QuickSort extends Sort {
	
	// Store benchmark results
	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	String sortName = "QuickSort\t";

	// Times the running of the sorting algorithm
	public double timer(Sort q, int[] array) {
		long startTime = System.nanoTime();
		this.quickSort(array, 0, array.length-1);
		long endTime = System.nanoTime();								//Run the sorting algorithm on the array
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (Double) elapsedMillis;
	}
	
	/*
	 *  Recursively 
	 */
	
	public void quickSort(int[] array, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int partitionIndex = partition(array, lowIndex, highIndex);
			quickSort(array, lowIndex, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, highIndex);
		}
	}

	private int partition(int[] array, int low, int high) {

		 /* Setting pivot to the element at the high index.
		 * This can be a poor choice especially for partially sorted data
		 */
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j <= high; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		return (i + 1);
	}

	//Swap the elements i and j
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	@Override
	public String toString () {
		return this.sortName;
	}

}


