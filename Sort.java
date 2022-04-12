package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public abstract class Sort {
	
	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();		//Store results from tests ran on the pseudorandom number arrays
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();		//Store results from tests ran on the partially sorted (or nearly ordered) arrays

	// Sort#timer Times the running of the sorting algorithm
	public double timer(Sort algo, int[] array) {
		long startTime = System.nanoTime();							
		this.sort(array);								//Run the sorting algorithm on the array
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (Double) elapsedMillis;					//Wrapping in Double for storage in linkedHashMap
	}
	
	//Sort#sort to be implemented by each individual sorting class
	public void sort(int[] array) {}
}
