package com.cbm.base.algself.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * ClassName: FibonacciSearchUtil <br/> 
 * Description: 斐波那契查找工具类. <br/> 
 * Function: 斐波那契查找. <br/> 
 * Reason: init. <br/> 
 * date: 2016年10月30日 上午12:29:27 <br/> 
 * 
 * @author byron 
 * @version 1.0 
 * @since JDK 1.7
 */
public class FibonacciSearchUtil {

	/**
	 * 斐波那契查找
	 * @param arr	待查找的数组
	 * @param key	要查找的值
	 * @return		key 在 arr 中得索引，-1 表示未找到
	 */
	public static int search(int[] arr, int key) {
		int old = arr.length;
		
		int k = 0;
		// 获取斐波那契数列中 -1后大于arr长度的最小项
		// 此处要求数组项数为 fibonacci(k) - 1 的原因：取出分割比较点的一个数后，数组还剩 fibonacci(k) - 2 项，
		// 正好可以分割为 fibonacci(k-1) - 1 和 fibonacci(k-2) - 1 项数的两部分
		while (old > fibonacci(k) - 1) {
			k ++;
		}
		
		int low = 0;
		int high = fibonacci(k) - 1;
		
		int[] arrCo = new int[high];
		// 将数组填充到符合斐波那契数列中某项的长度
		for (int i = 0; i < high; i++) {
			if (i < old) {
				arrCo[i] = arr[i];
			} else {
				// 超出原数组长度部分使用原数组最后一项填充
				arrCo[i] = arr[old - 1];
			}
		}
		
		// 将数组分为fibonacci(k-1)和fibonacci(k-2)两部分，以此分界点查找
		while (low <= high) {
			int mid = low + fibonacci(k-1) - 1;
			if (key > arrCo[mid]) {
				low = mid + 1;
				// 继续在后半部分查找，还有 fibonacci(k-2) -1 项
				k = k - 2;
			} else if (key < arrCo[mid]) {
				high = mid - 1;
				// 继续在前半部分查找，还有 fibonacci(k-1) -1 项
				k = k - 1;
			} else {
				// 已找到，若索引大于等于原数组长度，则在填充的项中找到，即为arr[old - 1]
				return mid >= old ? (old - 1) : mid;
			}
		}
		
		return -1;
	}
	
	/**
	 * 获取斐波那契数列中项
	 * @param n
	 * @return
	 */
	private static int fibonacci(int n) {
		return (n > 1) ? (fibonacci(n-1) + fibonacci(n-2)) : 1;
	}
	
	@Test
	public void testFs() {
		int[] arr = {1, 13, 20, 95, 210, 555, 1733, 3270};
		
		assertEquals(0, search(arr, 1));
		assertEquals(1, search(arr, 13));
		assertEquals(2, search(arr, 20));
		assertEquals(3, search(arr, 95));
		assertEquals(4, search(arr, 210));
		assertEquals(5, search(arr, 555));
		assertEquals(6, search(arr, 1733));
		assertEquals(7, search(arr, 3270));
	}
	
}
