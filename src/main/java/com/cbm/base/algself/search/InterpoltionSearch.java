package com.cbm.base.algself.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 插值查找（在二分查找的基础上改进而来，只支持已排序的情况）
 * @author byron
 *
 */
public class InterpoltionSearch {

	public static int search(int[] arr, int key) {
		return search(arr, 0, arr.length, key);
	}
	
	public static int search(int[] arr, int from, int to, int key) {
		to = to - 1;
		while (from <= to) {
			int middle = from + (to-from) * (key-arr[from]) / (arr[to]-arr[from]);
			int temp = arr[middle];
			if (key < temp) {
				to = middle - 1;
			} else if (key > temp) {
				from = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
	
	@Test
	public void testIs() {
		int[] arr = {3, 9, 11, 45, 66, 71, 177};
		assertEquals(0, search(arr, 3));
		assertEquals(1, search(arr, 9));
		assertEquals(2, search(arr, 11));
		assertEquals(3, search(arr, 45));
		assertEquals(4, search(arr, 66));
		assertEquals(5, search(arr, 71));
		assertEquals(6, search(arr, 177));
	}
}
