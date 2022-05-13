package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

// Each sorting algorithm class extends this class
// They must implement thier own sort() method
public abstract class Sort {
	
	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();		//Store results from tests ran on the pseudorandom number arrays
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();		//Store results from tests ran on the partially sorted (or nearly ordered) arrays

	// Times the length to sort a single array for a given sorting algorithm
	public double timeASingleTest(int[] array) {
		long startTime = System.nanoTime();							
		this.sort(array);								//Run the sorting algorithm on the array
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (Double) elapsedMillis;					//Wrapping in Double for storage in linkedHashMap
	}
	
	// runOnRandomlySortedData runs a sorting algorithm on pseudorandom data
	// @param numOfIterations How many times the sorting algorithm  runs for array size n 
	// @param n Size of the array
	public double runOnRandomlySortedData(int n, int numOfIterations) {
		double testTime = 0.0;
		
		for (int i = 0; i<numOfIterations; i++) {
			testTime += this.timeASingleTest(CreateArrays.createRandomArray(n));
		}
		return testTime;
	}
	
	
	public double runOnPartiallySortedData(int n, int numOfIterations) {
		double testTime = 0.0;
		
		for (int i = 0; i<numOfIterations; i++) {
			testTime += this.timeASingleTest(CreateArrays.partialSortedArray(n));
		}
		return testTime;
	}
	
	//Sort#sort to be implemented by each individual sorting class
	public void sort(int[] array) {}
}
