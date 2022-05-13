package ctaProject.ComputationalThinkingWithAlgorithms;

public class TimSort  extends Sort{

	String sortName = "TimSort\t\t";

	private static final int RUN = 32; //size of a run, typically 32 or 64	
	
	// Method to implement Sort#sort() 
	// Calls timSort with the array & its length as a parameters
	public void sort(int[] array) {
		timSort(array, array.length-1);
	}
	
	/*
	 * TimSort
	 * Code taken from JavaPoint (https://www.javatpoint.com)
	 * https://www.javatpoint.com/tim-sort
	 */
	
	// Method reutrns the min of a or b
	int min(int a, int b)    
	{    
	    if(a<b)    
	    return a;     
	    else     
	    return b;     
	}    
	// This method sorts array from starting index to ending index which is of size at most RUN   
	// Method to sort an array with insertion sort 
	void insertionSort(int array[], int beg, int end) 
	{  
	    int i, j, temp;  
	    for (i = beg + 1; i <= end; i++)   
	    {  
	        temp = array[i];  
	        j = i - 1;  
	  
	        while(j >= beg && temp <= array[j])    
	        {    
	            array[j+1] = array[j];     
	            j = j-1;    
	        }    
	        array[j+1] = temp;    
	    }  
	}  
	// Implementation of mergesort
	void merge(int array[], int beg, int mid, int end)    
	{    
	    int i, j, k;  
	    int n1 = mid - beg + 1;    
	    int n2 = end - mid;     
	  //temporary arrays    
	    int[] LeftArray = new int [n1];    
	    int[] RightArray = new int [n2];       
	    /* copy data to temp arrays */  
	    for (i = 0; i < n1; i++)    
	    LeftArray[i] = array[beg + i];    
	    for (j = 0; j < n2; j++)    
	    RightArray[j] = array[mid + 1 + j];        
	    i = 0;   
	    j = 0;   
	    k = beg;      
	    // Copy from one array to the other
	    while (i < n1 && j < n2)    
	    {    
	        if(LeftArray[i] <= RightArray[j])    
	        {    
	            array[k] = LeftArray[i];    
	            i++;    
	        }    
	        else    
	        {    
	            array[k] = RightArray[j];    
	            j++;    
	        }    
	        k++;    
	    }    
	    while (i<n1)    
	    {    
	        array[k] = LeftArray[i];    
	        i++;    
	        k++;    
	    }        
	    while (j<n2)    
	    {    
	        array[k] = RightArray[j];    
	        j++;    
	        k++;    
	    }    
	}    
	/* function to implement tim sort */  
	void timSort(int array[], int n)  
	{     
	    
		// Run insertion sort on each 32 element block of the array
	    for (int i = 0; i < n; i+=RUN)  
	    	// passing the min of (i+RUN-1) or (n-1) so we don't go out of bounds on the array
	        insertionSort(array, i, min((i+RUN-1), (n-1)));   
	    // Start merging from size RUN (or 32).  
	    for (int size = RUN; size < n; size = 2*size)  
	    {  
	        for (int beg = 0; beg < n; beg += 2*size)  
	        {  
	            /* find ending point of left subarray. The starting point of right sub array is mid + 1 */  
	            int mid = beg + size - 1;  
	            // Again get the min so we dont go out of bounds on the array
	            int end = min((beg + 2*size - 1),(n-1));  
	  
	            /* Merge subarray a[beg...mid] and a[mid+1...end] */  
	            if(mid < end)  
	                merge(array, beg, mid, end);  
	        }  
	    }  
	} 
	
	@Override
	public String toString () {
		return this.sortName;
	}
}
