package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public class ShellSort  extends Sort{
	
	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	String sortName = "ShellSort\t";

	
	public double timer(Sort s, int[] array) {
		long startTime = System.nanoTime();
		this.shellSort(array);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (double) elapsedMillis;
	}

	/* function to sort arr using shellSort */
	private void shellSort(int array[])
	{
		int n = array.length;

		// Start with a big gap, then reduce the gap
		for (int gap = n/2; gap > 0; gap /= 2)
		{
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1)
			{
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				int temp = array[i];

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
					array[j] = array[j - gap];

				// put temp (the original a[i]) in its correct
				// location
				array[j] = temp;
			}
		}
		
	}
	
	@Override
	public String toString () {
		return this.sortName;
	}


}



