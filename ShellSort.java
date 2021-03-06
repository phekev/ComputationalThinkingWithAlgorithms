package ctaProject.ComputationalThinkingWithAlgorithms;

public class ShellSort  extends Sort{

	String sortName = "ShellSort\t";

	/*
	 * Shell sort
	 * Code taken from Geeks for Geeks (https://www.geeksforgeeks.org)
	 * https://www.geeksforgeeks.org/shellsort/
	 *  
	 */
	
	
	/* method to sort array using shellSort */
	public void sort(int array[])
	{
		int n = array.length;

		// Start with a big gap, then reduce the gap
		// Gap reduces by half each loop eg. 32 -> 16 -> 8 -> 4 -> 2
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



