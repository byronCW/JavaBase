/**
 * @Title: SortTools.java
 * @Package com.cbm.base.algself.sort
 * @Description: 排序工具方法
 * @author byron
 * @date 2017年4月13日
 * @version V1.0
 */
package com.cbm.base.algself.sort;

import java.util.Arrays;

/**
 * @ClassName: SortTools
 * @Description: 排序算法中使用到的工具方法
 * @author byron
 * @date 2017年4月13日
 *
 */
public class SortTools {

    /**
     * @Description: 交换数组中指定位置的元素
     * @param @param arr
     * @param @param i
     * @param @param j    参数
     * @return void    返回类型
     * @throws
     */
    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    /**
     * @Description: 返回数组的字符串
     * @param @param arr
     * @param @return    参数
     * @return String    返回类型
     * @throws
     */
    public static String getString(int[] arr) {
        return Arrays.toString(arr);
    }

    /**
     * @Description: 打印数组（方便测试）
     * @param @param arr    参数
     * @return void    返回类型
     * @throws
     */
    public static void print(int[] arr) {
        System.out.println(getString(arr));
    }
}
