package ca.twu.cmpt231.assign1;

/**
 * CMPT 231 - Assignment 1.
 * 
 * Student name [PLEASE ENTER YOUR NAME] Student number [PLEASE ENTER YOUR
 * STUDENT NUMBER]
 * 
 * This class provides a way for us to observe empirically the runtime
 * complexity of various sorting algorithm. The "count" field of this class is
 * responsible for keeping track of the number of comparisons that a particular
 * sorting algorithm has made.
 * 
 * The objective of this assignment is to insert statements into appropriate
 * parts of the sorting algorithm codes so that the "count" field will be
 * reflective of the NUMBER OF COMPARISONS a sorting algorithm has done.
 * 
 * @author Samuel Leung (most of the codes are from Lewis et al.)
 */
public class AlgorithmProfiler {
	private int count; // counter to keep track of amount of resources taken by an algorithm

	public AlgorithmProfiler() {
		count = 0;
	}

	/**
	 * return the value of the count private field
	 */
	public int getCount() {
		return (count);
	}

	/**
	 * reset count to 0
	 */
	public void resetCount() {
		count = 0;
	}

	/**
	 * Sorts the specified array of objects using a bubble sort algorithm.
	 *
	 * PLEASE INSERT STATEMENTS IN THE BODY OF THIS METHOD TO INCREMENT "count"
	 * APPROPRIATELY TO REFLECT THE NUMBER OF COMPARISONS DONE.
	 *
	 * @author Lewis et al.
	 * @param data the array to be sorted
	 */
	public void bubbleSort(int[] data) {
		int position, scan;

		for (position = data.length - 1; position >= 0; position--) {
			for (scan = 0; scan <= position - 1; scan++) {
				if (data[scan] > data[scan + 1])
					swap(data, scan, scan + 1);
			}
		}
	}

	/**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @author Lewis et al.
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * 
	 * @author Lewis et al.
	 * @param data the array to be sorted
	 */
	public void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the quick
	 * sort algorithm.
	 * 
	 * @author Lewis et al.
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private void quickSort(int[] data, int min, int max) {
		if (min < max) {
			// create partitions
			int indexofpartition = partition(data, min, max);

			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1);

			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max);
		}
	}

	/**
	 * Used by the quick sort algorithm to find the partition.
	 * 
	 * PLEASE INSERT STATEMENTS IN THE BODY OF THIS METHOD TO INCREMENT "count"
	 * APPROPRIATELY TO REFLECT THE NUMBER OF COMPARISONS DONE.
	 * 
	 * @author Lewis et al.
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private int partition(int[] data, int min, int max) {
		int partitionelement;
		int left, right;
		int middle = (min + max) / 2;

		// use the middle data value as the partition element
		partitionelement = data[middle];

		// move it out of the way for now
		swap(data, middle, min);

		left = min;
		right = max;

		while (left < right) {
			// search for an element that is > the partition element
			while (left < right && data[left] <= partitionelement)
				left++;

			// search for an element that is < the partition element
			while (data[right] > partitionelement)
				right--;

			// swap the elements
			if (left < right)
				swap(data, left, right);
		}

		// move the partition element into place
		swap(data, min, right);

		return right;
	}

}
