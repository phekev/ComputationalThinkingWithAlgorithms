package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Controller {

	
	// Input size n for each test array
	static final int[] BENCHMARK_ARRAYSIZE = {10, 100, 1000, 2500, 5000, 7500};
				

	public static void main(String[] args) {
		
		/*
		 * Create an instance of each sorting algorithm
		 */
		InsertionSort insertSort = new InsertionSort();
		QuickSort quickSort = new QuickSort();
		RadixSortLSD radixSort = new RadixSortLSD();
		ShellSort shellSort = new ShellSort();
		TimSort timSort  = new TimSort();
		
		//List to store results of benchmarks of each sorting algorithm
		List<Sort> resultsOfBenchmark = new ArrayList<Sort>(
					List.of(insertSort, quickSort, radixSort, shellSort, timSort));
		

		//How many times to run the benchmark on each sorting algorithm			
		int numOfTimesToRunTest = 10;
		
		Controller controller = new Controller();
		controller.runRandomSortingTest(resultsOfBenchmark, numOfTimesToRunTest);
		controller.runPartialSortingTest(resultsOfBenchmark, numOfTimesToRunTest);
		
		//Print results of benchmarks to the console
		ResultsPrinter.print(resultsOfBenchmark, BENCHMARK_ARRAYSIZE);
		
		// Write results of benchmarks to a CSV file
		WriteResultstoFile.write(resultsOfBenchmark, BENCHMARK_ARRAYSIZE);

	}
	
	

	//Runs the benchmarking test on randomly sorted data
	private void runRandomSortingTest (List<Sort> sortingAlgorithms, int numOfTimesToRunTest) {

		// Run a test for each array of size n on each algorithm X number of times
		for (int n : BENCHMARK_ARRAYSIZE) {

			for(int j=0; j<sortingAlgorithms.size(); j++) {
				double totalTestTime = 0.0; 
				double averageTestTime = 0.0;
				
				totalTestTime += runOnRandomlySortedData(sortingAlgorithms.get(j), n, numOfTimesToRunTest);
				averageTestTime = totalTestTime / numOfTimesToRunTest;
				
				sortingAlgorithms.get(j).randomSortBenchmarkResults.put(n , averageTestTime);
			}
		}	
	}
	
	
	//Runs the benchmarking test on partially sorted / nearly sorted arrays
	private void runPartialSortingTest(List<Sort> sortingAlgorithms, int numOfTimesToRunTest) {

		// Run a test for each array of size n on each algorithm X number of times
		for (int n : BENCHMARK_ARRAYSIZE) {
			
			for(int j=0; j<sortingAlgorithms.size(); j++) {
				
				double totalTestTime = 0.0; 
				double averageTestTime = 0.0;
				
				totalTestTime += runOnPartiallySortedData(sortingAlgorithms.get(j), n, numOfTimesToRunTest);
				averageTestTime = totalTestTime / numOfTimesToRunTest;
				
				sortingAlgorithms.get(j).partialSortBenchmarkResults.put(n , averageTestTime);
				
			}
		}
	}
	
	
	private double runOnRandomlySortedData(Sort sortAlgo, int n, int numOfIterations) {
		double testTime = 0.0;
		for (int i = 0; i<numOfIterations; i++) {
			testTime += sortAlgo.timer(sortAlgo, CreateArrays.createRandomArray(n));
		}
		return testTime;
	}
	
	
	private double runOnPartiallySortedData(Sort sortAlgo, int n, int numOfIterations) {
		double testTime = 0.0;
		for (int i = 0; i<numOfIterations; i++) {
			testTime += sortAlgo.timer(sortAlgo, CreateArrays.partialSortedArray(n));
		}
		return testTime;
	}
	
	

}
