/**
 * @Title: SortTest.java
 * @Package com.cbm.base.algself.sort
 * @Description: TODO(用一句话描述该文件做什么)
 * @author byron
 * @date 2017年4月13日
 * @version V1.0
 */
package com.cbm.base.algself.sort;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @ClassName: SortTest
 * @Description: 排序算法测试类
 * @author byron
 * @date 2017年4月13日
 *
 */
public class SortTest {

	private int[] arr;
	
	private String sorted = "[5, 6, 9, 9, 10, 12, 27, 37, 61, 62, 63, 66, 85, 85, 89, 107, 125, 181, 255]";
	
	@Before
	public void before() {
		arr = new int[]{12, 9, 5, 89, 85, 62, 63, 107, 10, 6, 27, 85, 37, 61, 66, 125, 9, 181, 255};
	}
	
	@Test
	public void testBubble() {
		System.out.println("冒泡排序：");
		SortTools.print(arr);
		SortUtils.bubbleSort(arr);
		SortTools.print(arr);
		Assert.assertEquals(sorted, toString(arr));
	}
	
	@Test
	public void testInsert() {
		System.out.println("插入排序：");
		SortTools.print(arr);
		SortUtils.insertSort(arr);
		SortTools.print(arr);
		Assert.assertEquals(toString(arr), sorted);
	}
	
	@Test
	public void testShell() {
		System.out.println("希尔排序：");
		SortTools.print(arr);
		SortUtils.shellSort(arr);
		SortTools.print(arr);
		Assert.assertEquals(toString(arr), sorted);
	}
	
	@Test
	public void testSelect() {
		System.out.println("选择排序：");
		SortTools.print(arr);
		SortUtils.selectSort(arr);
		SortTools.print(arr);
		Assert.assertEquals(toString(arr), sorted);
	}
	
	@Test
	public void testMerge() {
		System.out.println("归并排序：");
		SortTools.print(arr);
		SortUtils.mergeSort(arr);
		SortTools.print(arr);
		Assert.assertEquals(toString(arr), sorted);
	}
	
	@Test
	public void testHeap() {
		System.out.println("堆排序：");
		SortTools.print(arr);
		SortUtils.heapSort(arr);
		SortTools.print(arr);
		Assert.assertEquals(toString(arr), sorted);
	}
	
	@Test
	public void testQuick() {
		System.out.println("快速排序：");
		SortTools.print(arr);
		SortUtils.quickSort(arr);
		SortTools.print(arr);
		Assert.assertEquals(toString(arr), sorted);
	}
	
	@Test
    public void testRadix() {
		System.out.println("基数排序：");
		SortTools.print(arr);
		SortUtils.radixSort(arr);
		SortTools.print(arr);
		Assert.assertEquals(toString(arr), sorted);
	}
	
	private String toString(int[] arr) {
		return Arrays.toString(arr);
	}
}
