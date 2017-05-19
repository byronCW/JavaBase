/**
 * @Title: SortUtils.java
 * @Package com.cbm.base.algself.sort
 * @Description: 排序算法
 * @author byron
 * @date 2017年4月13日
 * @version V1.0
 */
package com.cbm.base.algself.sort;

import java.util.ArrayList;

/**
 * @ClassName: SortUtils
 * @Description: 排序算法的实现（针对整型）
 * @author byron
 * @date 2017年4月13日
 *
 */
public class SortUtils {

    /**
     * @Description: 冒泡排序
     * @param @param arr    参数
     * @return void    返回类型
     * @throws
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortTools.swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 
     * @Description: 将数组中指定间隔的元素按照插入排序法排序
     * @param arr 待排序数组
     * @param start 排序开始的索引
     * @param gap  索引间隔的距离
     * @return void    返回类型
     * @throws
     */
    private static void insertSortGap(int[] arr, int start, int gap) {
        for (int i = start + gap; i < arr.length; i += gap) {
            // 遍历 i 位置之前的元素，将i位置元素插入合适的位置
            int j = i - gap;
            int inserted = arr[i];
            for (; j >= 0 && arr[j] > inserted; j -= gap) {
                arr[j + gap] = arr[j];
            }
            arr[j + gap] = inserted;
        }
    }

    /**
     * @Description: 插入排序
     * @param arr  参数
     * @return void    返回类型
     * @throws
     */
    public static void insertSort(int[] arr) {
        /*
         * for (int i = 1; i < arr.length; i++) { // 遍历 i 位置之前的元素，将i位置元素插入合适的位置
         * int j = i - 1; int inserted = arr[i]; for (; j >= 0 && arr[j] >
         * inserted; j--) { arr[j+1] = arr[j]; } arr[j+1] = inserted; }
         */

        insertSortGap(arr, 0, 1);
    }

    /**
     * 
     * @Description: 希尔排序
     * @param arr    参数
     * @return void    返回类型
     * @throws
     */
    public static void shellSort(int[] arr) {
        double g = arr.length;
        while (true) {
            // 循环以arr.length/2， arr.length/4，arr.length/8 ... 1 的间隔进行插入排序
            g = Math.ceil(g / 2);
            // 获取分组的间隔
            int gap = (int) g;
            for (int i = 0; i < gap; i++) {
                // 针对以gap间隔的所有分组进行插入排序
                insertSortGap(arr, i, gap);
            }

            if (gap == 1) {
                break;
            }
        }
    }

    /**
     * 
     * @Description: 选择排序
     * @param arr    参数
     * @return void    返回类型
     * @throws
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 记录将要被插入未排序元素中首位的元素索引
            int selected = i;
            int temp = arr[i];
            // 循环获取最小元素的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    selected = j;
                    temp = arr[j];
                }
            }
            // 若最小元素不是未排序元素第一个，则交换二者的位置
            if (selected != i) {
                SortTools.swap(arr, i, selected);
            }
        }
    }

    /**
     * @Description: 快速排序
     * @param arr    参数
     * @return void    返回类型
     * @throws
     */
    public static void quickSort(int[] arr) {
        quickRecursion(arr, 0, arr.length - 1);
    }

    /**
     * @Description: 快速排序的递归方法
     * @param arr
     * @param start
     * @param end  参数
     * @return void    返回类型
     * @throws
     */
    private static void quickRecursion(int[] arr, int start, int end) {
        if (start < end) {
            int middle = getMiddle(arr, start, end);
            quickRecursion(arr, start, middle - 1);
            quickRecursion(arr, middle + 1, end);
        }
    }

    /**
     * @Description: 以第一个元素为中点将数组分为两部分，并返回此中间数在分离后数组中的位置
     * @param arr
     * @return  参数
     * @return int    返回类型
     * @throws
     */
    private static int getMiddle(int[] arr, int start, int end) {
        int temp = arr[start];
        while (start < end) {
            // 从尾部向前遍历，找到一个小于temp的元素，存入数组前部，此位置的数据已被保存在temp或存入数组后部
            while (start < end && arr[end] >= temp) {
                end--;
            }
            arr[start] = arr[end];

            // 从头部向后遍历，找到一个大于temp的元素，存入数组后部
            while (start < end && arr[start] <= temp) {
                start++;
            }
            arr[end] = arr[start];
        }

        // 上述循环结束时, 最后一个大于temp的元素为arr[start], 被存入数组后部
        // 将中间数存入start位置
        arr[start] = temp;
        return start;
    }

    /**
     * @Description: 归并排序
     * @param @param arr    参数
     * @return void    返回类型
     */
    public static void mergeSort(int[] arr) {
        msRecursion(arr, 0, arr.length - 1);
    }

    /**
     * @Description: 归并排序的递归方法
     * @param arr
     * @param start
     * @param end  参数
     * @return void    返回类型
     */
    private static void msRecursion(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            msRecursion(arr, start, mid);
            msRecursion(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    /**
     * @Description: 归并方法
     * @param arr
     * @param start
     * @param mid
     * @param end  参数
     * @return void    返回类型
     */
    private static void merge(int[] arr, int start, int mid, int end) {

        int[] data = new int[arr.length];

        int count = end - start + 1;
        int startBak = start;

        int leftStart = start;
        int leftEnd = mid;
        int rightStart = mid + 1;
        int rightEnd = end;

        // 将数组已排好序的左右两部分按序合并到一起
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] < arr[rightStart]) {
                data[start++] = arr[leftStart++];
            } else {
                data[start++] = arr[rightStart++];
            }
        }

        // 以下两个while只会执行一个
        while (leftStart <= leftEnd) {
            data[start++] = arr[leftStart++];
        }
        while (rightStart <= rightEnd) {
            data[start++] = arr[rightStart++];
        }

        // 将排序后的元素复制会原来数组
        System.arraycopy(data, startBak, arr, startBak, count);
    }

    /**
     * @Description: 	堆排序:每次针对未排序的元素构建最大堆，然后交换堆顶和堆尾部，则此尾部为排序元素中的最大值；
     * 					再对此最大元素之外的元素继续进行上述过程
     * @param arr    参数
     * @return void    返回类型
     * @throws
     */
    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            buildMaxHeap(arr, arr.length - 1 - i);
            SortTools.swap(arr, 0, arr.length - 1 - i);
        }
    }

    /**
     * @Description: 构建最大堆
     * @param arr
     * @param last  构建最大堆最后一个元素的索引
     * @return void    返回类型
     * @throws
     */
    private static void buildMaxHeap(int[] arr, int last) {
        // (last - 1) / 2 是堆中最后一个父节点的索引
        for (int i = (last - 1) / 2; i >= 0; i--) {
            int k = i;
            while (k * 2 + 1 < last) {
                // 左子节点的索引
                int biggerIndex = k * 2 + 1;
                // biggerIndex < last 说明有右子节点
                if (biggerIndex < last
                        && arr[biggerIndex] < arr[biggerIndex + 1]) {
                    // 获得子节点中较大元素的索引
                    biggerIndex++;
                }

                if (arr[k] < arr[biggerIndex]) {
                    // 将父子节点中最大的值交换到父节点上
                    SortTools.swap(arr, k, biggerIndex);
                    // 父节点值交换到子节点后，可能破坏原来子节点与其子节点的最大堆排序，在此biggerIndex节点上构建最大堆
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * @Description: 基数排序
     * @param arr    参数
     * @return void    返回类型
     * @throws
     */
    public static void radixSort(int[] arr) {
        // 获取最大元素的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int maxBits = Integer.toString(max).length();

        // 初始化十个bucket,用于按位分组
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for (int j = 1; j <= maxBits; j++) {
            // 将数组元素按位分组
            assignByBit(arr, j, buckets);

            // 将组中元素按组的顺序重新归一
            gatherFromBuckets(arr, buckets);
        }
    }

    /**
     * @Description: 将数组元素按指定位上的数字分组
     * @param arr
     * @param bit 从右向左数的位数
     * @param buckets  参数
     * @return void    返回类型
     * @throws
     */
    private static void assignByBit(int[] arr, int bit,
            ArrayList<ArrayList<Integer>> buckets) {
        for (int i = 0; i < arr.length; i++) {
            // 计算指定位上的数字
            int bitVal = arr[i] % (int) Math.pow(10, bit)
                    / (int) Math.pow(10, bit - 1);
            buckets.get(bitVal).add(arr[i]);
        }
    }

    /**
     * @Description: 将桶中的数据按照桶的顺序依次放入数组中
     * @param arr
     * @param buckets  参数
     * @return void    返回类型
     * @throws
     */
    private static void gatherFromBuckets(int[] arr,
            ArrayList<ArrayList<Integer>> buckets) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> bucket = buckets.get(i);
            while (bucket.size() > 0) {
                arr[count++] = bucket.remove(0);
            }
        }
    }
}
