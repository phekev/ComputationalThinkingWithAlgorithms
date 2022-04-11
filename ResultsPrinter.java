package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.List;
import java.util.Map;

public class ResultsPrinter {

	public static void print(List<Sort> sorts, int[] testInputSizes) {
		System.out.print("\t\t   |   ");
		for( int i = 0; i < testInputSizes.length; i++ ) {
			System.out.printf(String.format("%5d", testInputSizes[i]) + "   | "); 	
		}
		printRandom(sorts, testInputSizes);
		System.out.println();
		printPartial(sorts, testInputSizes);
		
	}

		
		private static void printRandom(List<Sort> sorts, int[] testInputSizes) {

			for (int j = 0; j < sorts.size(); j++) {
				System.out.print("\n" + sorts.get(j).toString() + "   |   ");

				for (Map.Entry<Integer,Double> sortTypes : sorts.get(j).randomSortBenchmarkResults.entrySet()){
					System.out.printf(String.format("%.3f", sortTypes.getValue()) + "   | ");
				}

			}
		}

		private static void printPartial(List<Sort> sorts, int[] testInputSizes) {

			for (int j = 0; j < sorts.size(); j++) {
				System.out.print("\n" + sorts.get(j).toString() + "   |   ");

				for (Map.Entry<Integer,Double> sortTypes : sorts.get(j).partialSortBenchmarkResults.entrySet()){
					System.out.printf(String.format("%.3f", sortTypes.getValue()) + "   | ");
				}

			}
		}

			
		


	}
	
