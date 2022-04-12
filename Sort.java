package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public abstract class Sort {

	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();

	// Times the running of the sorting algorithm
	public double timer(Sort i, int[] array) {
		long startTime = System.nanoTime();							
		this.sort(array);								//Run the sorting algorithm on the array
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (Double) elapsedMillis;
	}
	
	public void sort(int[] array) {
		
	}
}
