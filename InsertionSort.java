package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public class InsertionSort extends Sort{
	
	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	String sortName = "InsertionSort\t";

	public InsertionSort() {
		
		
	}
	
	
	public double timer(Sort i, int[] array) {
		long startTime = System.nanoTime();
		this.insertionSort(array);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (Double) elapsedMillis;
	}
	
	private void insertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;

			while (j > 0 && array[j] > temp) {
				array[j + 1] = array[j];
				array[j--] = temp;
			}
		}
	}
	
	
	@Override
	public String toString () {
		return this.sortName;
	}


	

}
