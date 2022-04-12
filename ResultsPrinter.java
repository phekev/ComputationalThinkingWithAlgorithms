package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.List;
import java.util.Map;


/*
 *  Utility class to print results to the console
 *  
 */
public class ResultsPrinter {

	// Print the test array sizes
	public static void print(List<Sort> sorts, int[] testInputSizes) {
		System.out.print("\t\t\t");
		for( int i = 0; i < testInputSizes.length; i++ ) {
			System.out.printf(String.format("%-5d", testInputSizes[i]) + "\t"); 	
		}
		printRandom(sorts, testInputSizes);
		System.out.println();
		printPartial(sorts, testInputSizes);
		
	}

		// Print the results of the pseudorandom number sorting benchmarks
		private static void printRandom(List<Sort> sorts, int[] testInputSizes) {

			for (int j = 0; j < sorts.size(); j++) {
				System.out.print("\n" + sorts.get(j).toString() + "\t");

				for (Map.Entry<Integer,Double> sortTypes : sorts.get(j).randomSortBenchmarkResults.entrySet()){
					System.out.printf(String.format("%.3f", sortTypes.getValue()) + "\t");
				}

			}
		}
		
		// Print results of the partially sorted sorting benchmarks
		private static void printPartial(List<Sort> sorts, int[] testInputSizes) {
			
			System.out.print("\nPartially sorted results");
			for (int j = 0; j < sorts.size(); j++) {
				System.out.print("\n" + sorts.get(j).toString() + "\t");

				for (Map.Entry<Integer,Double> sortTypes : sorts.get(j).partialSortBenchmarkResults.entrySet()){
					System.out.printf(String.format("%.3f", sortTypes.getValue()) + "\t");
				}

			}
		}

			
		


	}
	
