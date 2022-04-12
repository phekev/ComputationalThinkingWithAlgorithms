package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public class QuickSort extends Sort {
	
	String sortName = "QuickSort\t";

	/*
	 *  Recursively 
	 */
	public void sort (int[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	private void quickSort(int[] array, int lowIndex, int highIndex) {
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


