package ctaProject.ComputationalThinkingWithAlgorithms;

public class QuickSort extends Sort {
	
	String sortName = "QuickSort\t";

	/* 
	 *  QuickSort#sort()
	 *  Method with extra parameters to call QuickSort#quickSort()
	 */
	public void sort (int[] array) {
		quickSort(array, 0, array.length-1);
	}
	
	/*
	 * Quicksort
	 * Code taken from Geeks for Geeks (https://www.geeksforgeeks.org)
	 * https://www.geeksforgeeks.org/quick-sort/
	 */
	
	private void quickSort(int[] array, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int partitionIndex = partition(array, lowIndex, highIndex);
			quickSort(array, lowIndex, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, highIndex);
		}
	}

	private int partition(int[] array, int lowIndex, int highIndex) {

		 /* Setting pivot to the element at the high index.
		 * This can be a poor choice especially for partially sorted data
		 */
		int pivot = array[highIndex];
		// Initially i will have a value of -1
		int i = lowIndex - 1;

		for (int j = lowIndex; j <= highIndex; j++) {
			if (array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, highIndex);
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


