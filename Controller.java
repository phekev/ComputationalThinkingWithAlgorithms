package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.ArrayList;
import java.util.List;


public class Controller {

	
	// Input size n for each test array
	static final int[] BENCHMARK_ARRAYSIZE = {10, 100, 1000, 2500, 5000, 7500, 10000, 20000, 50000};
										
				
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
		List<Sort> sortingAlgorithms = new ArrayList<Sort>(
					List.of(insertSort, quickSort, radixSort, shellSort, timSort));
		

		//How many times to run the benchmark on each sorting algorithm			
		int numOfTimesToRunTest = 10;
		
		Controller controller = new Controller();
		controller.runRandomSortingTest(sortingAlgorithms, numOfTimesToRunTest);
		controller.runPartialSortingTest(sortingAlgorithms, numOfTimesToRunTest);
		
		//Print results of benchmarks to the console
		ResultsPrinter.print(sortingAlgorithms, BENCHMARK_ARRAYSIZE);
		
		// Write results of benchmarks to a CSV file
		WriteResultstoFile.write(sortingAlgorithms, BENCHMARK_ARRAYSIZE);

	}
	
	/*
	*   An issue I ran into was the duplication of code to run the two separate tests
	*   Initially I used an enum and passed a flag to set if the test was to random or partially sorted
	*   This was difficult to follow and unintuitive
	*   There is probably a pattern for this that I just haven't seen.
	*   	
	*/
	//Runs the benchmarking test on randomly sorted data
	//Times the total cumulative time to run the sorting algorithm for a given array size n
	//@param sortingAlgorithms A list of the sorting algorithms to be benchmarked
	//@param numOfTimesToRunTest How many times to sort a new array  
	private void runRandomSortingTest (List<Sort> sortingAlgorithms, int numOfTimesToRunTest) {
		// Run a test for each array of size n on each algorithm 
		for (int n : BENCHMARK_ARRAYSIZE) {
			for(int sortAlgoToTest=0; sortAlgoToTest<sortingAlgorithms.size(); sortAlgoToTest++) {
				double totalTestTime = 0.0; 
				double averageTestTime = 0.0;
				// Cumulative time taken to test array[n] x number of times
				totalTestTime += sortingAlgorithms.get(sortAlgoToTest)
									.runOnRandomlySortedData(n, numOfTimesToRunTest);
				averageTestTime = totalTestTime / numOfTimesToRunTest;
				// Put the average time into the linkedHashMap for the sorting algorithm being run
				sortingAlgorithms.get(sortAlgoToTest).randomSortBenchmarkResults.put(n , averageTestTime);
			}
		}	
	}

	//Runs the benchmarking test on partially sorted / nearly sorted arrays
	private void runPartialSortingTest(List<Sort> sortingAlgorithms, int numOfTimesToRunTest) {

		// Run a test for each array of size n on each algorithm
		for (int n : BENCHMARK_ARRAYSIZE) {
			
			for(int sortAlgoToTest=0; sortAlgoToTest<sortingAlgorithms.size(); sortAlgoToTest++) {
				
				double totalTestTime = 0.0; 
				double averageTestTime = 0.0;
				// Cumulative time taken to test array[n] x number of times
				totalTestTime += sortingAlgorithms.get(sortAlgoToTest).runOnPartiallySortedData(n, numOfTimesToRunTest);
				averageTestTime = totalTestTime / numOfTimesToRunTest;
				
				// Put the average time into the linkedHashMap for the sorting algorithm being run
				sortingAlgorithms.get(sortAlgoToTest).partialSortBenchmarkResults.put(n , averageTestTime);
				
			}
		}
	}
	
	

	
	

}
