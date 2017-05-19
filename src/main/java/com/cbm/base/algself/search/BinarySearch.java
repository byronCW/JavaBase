package com.cbm.base.algself.search;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 二分查找（需要数组已排序）,通常情况下轮询方式的效率高于递归方式
 * 
 * @author byron
 *
 */
public class BinarySearch {

	public static <E extends Comparable<E>> int binarySearchR(E[] array, E key) throws Exception {
		return binarySearchR(array, 0, array.length, key);
	}
	
	public static <E extends Comparable<E>> int binarySearchL(E[] array, E key) throws Exception {
		return binarySearchL(array, 0, array.length, key);
	}
	
	/**
	 * 递归方式的二分查找
	 * 
	 * @param array
	 *            被查找的数组
	 * @param from
	 *            查找的起始索引（包含在内）
	 * @param to
	 *            查找的结束索引（不包含）
	 * @param key
	 *            要查找的值
	 * @return key 在 array 中的索引，-1表示未找到
	 * @throws Exception
	 */
	public static <E extends Comparable<E>> int binarySearchR(E[] array, int from, int to, E key) throws Exception {

		if (from <= to) {
			int middle = (from + to) >>> 1; // 右移即除2
			E temp = array[middle];
			if (temp.compareTo(key) > 0) {
				to = middle - 1;
			} else if (temp.compareTo(key) < 0) {
				from = middle + 1;
			} else {
				return middle;
			}
		}
		return binarySearchR(array, from, to, key);
	}

	/**
	 * 轮询方式的二分查找
	 * 
	 * @param array
	 * @param from
	 * @param to
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static <E extends Comparable<E>> int binarySearchL(E[] array, int from, int to, E key) throws Exception {
		
		// 添加此句，参数to必须传数组长度
		to = to -1;	
		
		while (from <= to) {
			int middle = (from + to) >>> 1; // 右移即除2
			E temp = array[middle];
			if (temp.compareTo(key) > 0) {
				to = middle - 1;
			} else if (temp.compareTo(key) < 0) {
				from = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}

	@Test
	public void testBs() throws Exception {
		Integer[] a1 = {2, 5, 19, 33, 105, 213, 622, 1009};
		Integer[] a2 = {2, 19, 33, 105, 213, 622, 1009};
		
		int in11 = BinarySearch.binarySearchL(a1, 0, a1.length, 1009);
		int in21 = BinarySearch.binarySearchL(a2, 0, a2.length, 1009);
		Assert.assertEquals(7, in11);
		Assert.assertEquals(6, in21);
	}
}
