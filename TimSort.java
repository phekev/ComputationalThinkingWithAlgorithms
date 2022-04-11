package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public class TimSort  extends Sort{
	
	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	String sortName = "TimSort\t\t";

	private static final int RUN = 32; //size of a run, typically 32 or 64
	
	
	public double timer(Sort t, int[] array) {
		long startTime = System.nanoTime();
		this.timSort(array, array.length-1);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (double) elapsedMillis;
	}
	
	int min(int a, int b)    
	{    
	    if(a<b)    
	    return a;     
	    else     
	    return b;     
	}    
	/* This function sorts array from starting index to ending index which is of   
	size at most RUN */  
	void insertionSort(int a[], int beg, int end) /* function to sort an array with   
	insertion sort */  
	{  
	    int i, j, temp;  
	    for (i = beg + 1; i <= end; i++)   
	    {  
	        temp = a[i];  
	        j = i - 1;  
	  
	        while(j >= beg && temp <= a[j])    
	        {    
	            a[j+1] = a[j];     
	            j = j-1;    
	        }    
	        a[j+1] = temp;    
	    }  
	}  
	/* Function to merge the sorted runs */  
	void merge(int a[], int beg, int mid, int end)    
	{    
	    int i, j, k;  
	    int n1 = mid - beg + 1;    
	    int n2 = end - mid;     
	  //temporary arrays    
	    int[] LeftArray = new int [n1];    
	    int[] RightArray = new int [n2];       
	    /* copy data to temp arrays */  
	    for (i = 0; i < n1; i++)    
	    LeftArray[i] = a[beg + i];    
	    for (j = 0; j < n2; j++)    
	    RightArray[j] = a[mid + 1 + j];        
	    i = 0;   
	    j = 0;   
	    k = beg;      
	    while (i < n1 && j < n2)    
	    {    
	        if(LeftArray[i] <= RightArray[j])    
	        {    
	            a[k] = LeftArray[i];    
	            i++;    
	        }    
	        else    
	        {    
	            a[k] = RightArray[j];    
	            j++;    
	        }    
	        k++;    
	    }    
	    while (i<n1)    
	    {    
	        a[k] = LeftArray[i];    
	        i++;    
	        k++;    
	    }        
	    while (j<n2)    
	    {    
	        a[k] = RightArray[j];    
	        j++;    
	        k++;    
	    }    
	}    
	/* function to implement tim sort */  
	void timSort(int a[], int n)  
	{     
	    /* Sort individual subarrays of size RUN */  
	    for (int i = 0; i < n; i+=RUN)  
	        insertionSort(a, i, min((i+RUN-1), (n-1)));   
	    // Start merging from size RUN (or 32).  
	    for (int size = RUN; size < n; size = 2*size)  
	    {  
	        for (int beg = 0; beg < n; beg += 2*size)  
	        {  
	            /* find ending point of left subarray. The   
	starting point of right sub array is mid + 1 */  
	            int mid = beg + size - 1;  
	            int end = min((beg + 2*size - 1),(n-1));  
	  
	            /* Merge subarray a[beg...mid] and a[mid  
	+1...end] */  
	            if(mid < end)  
	                merge(a, beg, mid, end);  
	        }  
	    }  
	} 
	
	@Override
	public String toString () {
		return this.sortName;
	}
}