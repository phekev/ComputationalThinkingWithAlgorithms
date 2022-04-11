package ctaProject.ComputationalThinkingWithAlgorithms;

import java.util.LinkedHashMap;

public class RadixSortLSD  extends Sort{
	
	LinkedHashMap<Integer, Double> randomSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	LinkedHashMap<Integer, Double> partialSortBenchmarkResults = new LinkedHashMap<Integer, Double>();
	String sortName = "RadixSortLSD \t";
	
	
	public double timer(Sort r, int[] array) {
		long startTime = System.nanoTime();
		this.sort(array);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		double elapsedMillis = (double) timeElapsed / 1000000;
		return (double) elapsedMillis;
	}
	
	/*
	 *  Radix Sort Least Significant Digit
	 *  Code taken from Section 5.1 of
	 *  Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne.
	 *  via Princeton.edu 12/03/2022
	 *   https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/LSD.java.html
	 *  
	 */
	
	 private static final int BITS_PER_BYTE = 8;
	
    public void sort(int[] arr) {
        final int BITS = 32;                 // each int is 32 bits 
        final int R = 1 << BITS_PER_BYTE;    // each bytes is between 0 and 255
        final int MASK = R - 1;              // 0xFF
        final int w = BITS / BITS_PER_BYTE;  // each int is 4 bytes

        int n = arr.length;
        int[] aux = new int[n];

        for (int d = 0; d < w; d++) {         

            // compute frequency counts
            int[] count = new int[R+1];
            for (int i = 0; i < n; i++) {           
                int c = (arr[i] >> BITS_PER_BYTE*d) & MASK;
                count[c + 1]++;
            }

            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == w-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
            }

            // move data
            for (int i = 0; i < n; i++) {
                int c = (arr[i] >> BITS_PER_BYTE*d) & MASK;
                aux[count[c]++] = arr[i];
            }

            // copy back
            for (int i = 0; i < n; i++)
                arr[i] = aux[i];
        }
    }
    
    
    /*****************************************************************************
    *  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
    *
    *  This file is part of algs4.jar, which accompanies the textbook
    *
    *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
    *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
    *      http://algs4.cs.princeton.edu
    *
    *
    *  algs4.jar is free software: you can redistribute it and/or modify
    *  it under the terms of the GNU General Public License as published by
    *  the Free Software Foundation, either version 3 of the License, or
    *  (at your option) any later version.
    *
    *  algs4.jar is distributed in the hope that it will be useful,
    *  but WITHOUT ANY WARRANTY; without even the implied warranty of
    *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    *  GNU General Public License for more details.
    *
    *  You should have received a copy of the GNU General Public License
    *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
    ******************************************************************************/
	
    @Override
	public String toString () {
		return this.sortName;
	}

}
