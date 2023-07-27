package com.quicksort.quicksort;

/*
 * The main idea of quick sort algorithm is:
 *   1. To choose reference element of the given array (usually it is named pivot).
 *   2. To compare pivot with other elements of the given array, and separate array on two subarrays.
 *   3. To do the same with subarrays using recursion.
 * */
public class QuickSort {
	// Swapping of two elements in array
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Getting index that separates given array on two subarrays
	// the left one will contain numbers bigger than pivot
	// the right one will contain numbers smaller than pivot
	private static int separate(int[] array, int firstIndex, int lastIndex) {
		int pivot = array[lastIndex];
		int separatingIndex = firstIndex;

		for (int j = firstIndex; j < lastIndex; j++) {
			if (array[j] <= pivot) {
				separatingIndex++;
				swap(array, separatingIndex - 1, j);
			}
		}

		swap(array, separatingIndex, lastIndex);
		return separatingIndex;
	}

	public static void quickSort(int[] array, int firstIndex, int lastIndex) {
		if(firstIndex >= lastIndex) return;

		// Getting separating index from 'private static int separate' function
		int separatingIndex = separate(array, firstIndex, lastIndex);
		// Sorting two subarrays using recursion
		quickSort(array, firstIndex, separatingIndex - 1);
		quickSort(array, separatingIndex + 1, lastIndex);
	}



}