package ctaProject.ComputationalThinkingWithAlgorithms;

public class InsertionSort extends Sort{
	
	String sortName = "InsertionSort\t";
	
	/*
	 *	Insertion sort 
	 *
	 *  Starting on the left compare each element with the one to its left.
	 *  If the element is larger than the left we swap these two elements
	 *  and continue working to the left comparing until the element to the left is smaller than the current element.
 	 */
	public void sort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			//At beginning j = 0
			int j = i - 1;						

			// While not at the leftmost element and the element at array[j] is larger than the element at temp
			while (j > 0 && array[j] > temp) {	
				// Swap elements at j and j+1
				array[j + 1] = array[j]; 
				// Move leftwards along the array
				array[j--] = temp;				
			}
		}
	}
	
	
	@Override
	public String toString () {
		return this.sortName;
	}


	

}
