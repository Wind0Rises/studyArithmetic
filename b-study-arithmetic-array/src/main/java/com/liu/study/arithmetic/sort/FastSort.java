package com.liu.study.arithmetic.sort;

/**
 * @desc 快速排序。
 *      1、先找到一个中间的支点。
 *      2、从左往右找比支点大的数，从右往左找比支点小的数，进行交换，直到两者相交。
 *      3、然后把数组分为左右两个部分，进行递归上面两的操作。
 *
 * @author Liuweian
 * @createTime 2020/6/13 10:09
 * @version 1.0.0
 */
public class FastSort {

    public static void main(String[] args) {
        int[] sortedArray = new int[]{1, 5, 45, 25, 6, 69, 34, 89, 28, 3};

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + ", ");
        }
        System.out.println();

        quickSort(sortedArray, 0, sortedArray.length - 1);

        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + ", ");
        }
    }



    public void liu(int[] liu, int L, int R) {
        int module = (L + R)/2;

        int i = L;
        int j = R;
        int pivot = liu[module];

        if(i < j) {
            while (pivot > liu[i]) {
                i++;
            }

            while(pivot < liu[j]) {
                j++;
            }

            while (i <= j) {
                int temp = liu[i];
                liu[i] = liu[j];
                liu[i] = temp;
            }
        }

        if(L < j) {
            liu(liu, L, j);
        }

        if (R > i) {

        }

    }













    /**
     * 快速排序
     *
     * @param arr
     * @param L   指向数组第一个元素
     * @param R   指向数组最后一个元素
     */
    public static void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;

        //支点
        int pivot = arr[(L + R) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            //寻找直到比支点大的数
            while (pivot > arr[i]) {
                i++;
            }

            //寻找直到比支点小的数
            while (pivot < arr[j]) {
                j--;
            }

            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。

        System.out.println("########################    支点：" + pivot + ",    i: " + i  + ",     j: " + j + "       #########################   ");
        for (int w = 0; w < arr.length; w++) {
            System.out.print(arr[w] + ", ");
        }
        System.out.println();

        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j) {
            quickSort(arr, L, j);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R) {
            quickSort(arr, i, R);
        }
    }

}
