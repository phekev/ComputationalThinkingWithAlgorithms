package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.Arrays;


public class RadixSortLSD  extends Sort{

	String sortName = "RadixSortLSD \t";	
	
	/*
	 *  Radix Sort Least Significant Digit
	 *  Code taken from Geekific (https://www.youtube.com/c/Geekific)
	 *  https://github.com/geekific-official/geekific-youtube/blob/main/sort-radix/src/com/youtube/geekific/RadixSort.java
	 *  
	 */
	
	
	
    public void sort(int[] arr) {
    	// Gets the max value from the array
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        // Increasing exp by an order of ten each iteration. So it goes 1, 10, 100 etc. This is the divisor for extracting the digits
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp, arr);
        }
        
    }
    // A modified version of counting sort
    private void countSort(int exp, int[] arr) {
    	
        int[] output = new int[arr.length];
        // countArray has length 10 as it only needs to store the count of the digits 0-9
        int[] countArray = new int[10];

        // Store count of occurrences in countArray[]
        for (int value : arr) {
        	// This is where the digit is 'extracted' eg value = 638, exp=100 -> countArray[(638/100)%10] -> countArray[6]
            countArray[(value / exp) % 10]++;
        }

        // Change countArray[i] so that countArray[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            
            int positionInArray = countArray[(current / exp) % 10] - 1;
            output[positionInArray] = current;
            countArray[(current / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
        
        // The method sort() below splits (partitions) the input array into an array of negative numbers and of positive numbers
        // I was only dealing with positive numbers so don't need this method
        /*
        public void sort() {
            Map<Boolean, List<Integer>> splitArray = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i < 0));
            int[] negativeInts = radixSort(splitArray.get(true).stream().mapToInt(Integer::intValue).map(Math::abs).toArray());
            int[] positiveInts = radixSort(splitArray.get(false).stream().mapToInt(Integer::intValue).toArray());
            for (int i = negativeInts.length - 1, j = 0; i >= 0; i--, j++) arr[j] = -negativeInts[i];
            System.arraycopy(positiveInts, 0, arr, negativeInts.length, positiveInts.length);
        }
    	*/

    }


	
    @Override
	public String toString () {
		return this.sortName;
	}

}
