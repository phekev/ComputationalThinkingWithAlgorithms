package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public abstract class Sort {

	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
//	String sortName;
//	
//	
//	public String toString () {
//		return this.sortName;
//	}


	protected abstract double timer(Sort sort, int[] createRandomArray);

}
