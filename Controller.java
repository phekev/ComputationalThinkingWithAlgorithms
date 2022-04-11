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
	static final int[] BENCHMARK_ARRAYSIZE = {10, 100, 1000, 2500, 5000, 7500, 50000, 100000, 500000};
				

	/*
	 * Run 
	 */
	public static void main(String[] args) {
		
		//Create an instance of each sorting algorithm
		InsertionSort insertRandom = new InsertionSort();
		QuickSort quickRandom = new QuickSort();
		RadixSortLSD radixRandom = new RadixSortLSD();
		ShellSort shellRandom = new ShellSort();
		TimSort timsRandom  = new TimSort();
		
		//List to store results of benchmarks of each sorting algorithm
		List<Sort> resultsOfBenchmark = new ArrayList<Sort>(
					List.of(insertRandom, quickRandom, radixRandom, shellRandom, timsRandom));
		

		//How many times to run the benchmark on each sorting algorithm			
		int numOfTimesToRunTest = 10;
		
		Controller controller = new Controller();
		controller.runRandomSortingTest(resultsOfBenchmark, numOfTimesToRunTest);
		controller.runPartialSortingTest(resultsOfBenchmark, numOfTimesToRunTest);
		
		//Print results of benchmarks on randomly sorted data
		ResultsPrinter.print(resultsOfBenchmark, BENCHMARK_ARRAYSIZE);

	}
	
	

	//Runs the benchmarking test on randomly sorted data
	private void runRandomSortingTest (List<Sort> randomSortAlgorithms, int numOfTimesToRunTest) {

		// Run a test for each array of size n on each algorithm X number of times
		for (int n : BENCHMARK_ARRAYSIZE) {
			for(int j=0; j<randomSortAlgorithms.size(); j++) {
				double totalTestTime = 0.0; 
				double averageTestTime = 0.0;
				
				totalTestTime += runTestsOnRandomlySortedData(randomSortAlgorithms.get(j), n, numOfTimesToRunTest);
				averageTestTime = totalTestTime / numOfTimesToRunTest;
				
				randomSortAlgorithms.get(j).randomSortBenchmarkResults.put(n , averageTestTime);
			}
		}	
	}
	
	private void runPartialSortingTest(List<Sort> partialSortResults, int numOfTimesToRunTest) {

		// Run a test for each array of size n on each algorithm X number of times
		for (int n : BENCHMARK_ARRAYSIZE) {
			for(int j=0; j<partialSortResults.size(); j++) {
				
				double totalTestTime = 0.0; 
				double averageTestTime = 0.0;
				
				totalTestTime += runTestsOnPartiallySortedData(partialSortResults.get(j), n, numOfTimesToRunTest);
				averageTestTime = totalTestTime / numOfTimesToRunTest;
				
				partialSortResults.get(j).partialSortBenchmarkResults.put(n , averageTestTime);
				
			}
		}
	}
	
	private double runTestsOnRandomlySortedData(Sort sortAlgo, int n, int numOfIterations) {
		double testTime = 0.0;
		for (int i = 0; i<numOfIterations; i++) {
			testTime += sortAlgo.timer(sortAlgo, CreateArrays.createRandomArray(n));
		}
		return testTime;
	}
	
	private double runTestsOnPartiallySortedData(Sort sortAlgo, int n, int numOfIterations) {
		double testTime = 0.0;
		for (int i = 0; i<numOfIterations; i++) {
			testTime += sortAlgo.timer(sortAlgo, CreateArrays.partialSortedArray(n));
		}
		return testTime;
	}
	
	

}
