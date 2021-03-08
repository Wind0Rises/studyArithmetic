package com.liu.study.arithmetic.sparse;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 稀疏数组：
 *
 * 1.什么是稀疏数组?
 *      第一个数据记录原始数组有几行几列多少个非0的数据。
 *      剩余的数据，记录具体每一个数据在第几很第几列，值是多少？
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/5 21:49
 */
public class SparseArrayDemo {

    public static void main(String[] args) {
        /**
         * 第一部分；从二维数组装换为稀疏数组。
         */
        // firstTest();

        /**
         * 第二部分：从一个稀疏数组，转换为二维数组。
         */
        secondTest();
    }

    /**
     * 第一部分；从二维数组装换为稀疏数组。
     */
    private static void firstTest() {
        int[][] twoDimensionAndPrint = createTwoDimensionAndPrint();
        System.out.println("\n\n");
        fromTwoDimensionToSparseArr(twoDimensionAndPrint);
    }

    /**
     * 第二部分：从一个稀疏数组，转换为二维数组。
     */
    private static void secondTest() {
        int[][] sparseAndPrint = createSparseAndPrint();
        System.out.println("\n\n");
        fromSparseArrToTwoDimension(sparseAndPrint);
    }


    /**
     * 创建一个二维数组，并打印二维数组。
     */
    public static int[][] createTwoDimensionAndPrint() {
        // 01、创建二维数组
        Random random = new Random();
        int lineNumber = random.nextInt(5) + 5;
        int rowNumber = random.nextInt(5) + 5;
        int[][] newArr = new int[lineNumber][rowNumber];

        // 02、随机添加几个值。
        IntStream.range(0, 10).forEach(item -> {
            int line = random.nextInt(lineNumber);
            int row = random.nextInt(rowNumber);
            newArr[line][row] = random.nextInt(9) + 20;
        });

        // 03、打印数组。
        printTwoDimension(newArr);
        return newArr;
    }

    /**
     * 创建一个稀疏数组，并打印稀疏数组。
     * TODO:可能会有重复的。
     */
    public static int[][] createSparseAndPrint() {
        // 01、创建二维数组
        Random random = new Random();
        int lineNumber = random.nextInt(5) + 5;
        int[][] newArr = new int[lineNumber][3];


        // 02、定义第一行数据。
        int first = random.nextInt(5) + 5;
        int second = random.nextInt(5) + 5;
        newArr[0][0] = first;
        newArr[0][1] = second;
        newArr[0][2] = lineNumber - 1;


        // 03、随机添加几个值。
        for (int i = 0; i < lineNumber - 1; i++) {
            newArr[i + 1][0] = random.nextInt(first);
            newArr[i + 1][1] = random.nextInt(second);
            newArr[i + 1][2] = random.nextInt(9) + 20;
        }

        // 04、打印数组。
        printTwoDimension(newArr);
        return newArr;
    }

    /**
     * 打印二维数组。
     * @param twoDimension
     */
    private static void printTwoDimension(int[][] twoDimension) {
        for (int i = 0; i < twoDimension.length; i++) {
            for (int j = 0; j < twoDimension[0].length; j++) {
                int value = twoDimension[i][j];
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }
    }


    /**
     * 将一个二维数组，转换为稀疏数组。
     */
    private static void fromTwoDimensionToSparseArr(int[][] twoDimension) {
        // 01、获取二维数组元素的个数。
        int numberCount = 0;
        for (int i = 0; i < twoDimension.length; i++) {
            for (int j = 0; j < twoDimension[0].length; j++) {
                if (0 != twoDimension[i][j]) {
                    numberCount++;
                }
            }
        }

        // 02、创建一个新的稀疏数组
        int[][] sparseArr = new int[numberCount + 1][3];
        sparseArr[0][0] = twoDimension.length;
        sparseArr[0][1] = twoDimension[0].length;
        sparseArr[0][2] = numberCount;

        // 03、保存其他非0数据到稀疏数组中。
        int line = 1;
        for (int i = 0; i < twoDimension.length; i++) {
            for (int j = 0; j < twoDimension[0].length; j++) {
                if (0 != twoDimension[i][j]) {
                    sparseArr[line][0] = i;
                    sparseArr[line][1] = j;
                    sparseArr[line][2] = twoDimension[i][j];
                    line++;
                }
            }
        }

        // 04、打印
        printTwoDimension(sparseArr);
    }


    /**
     * 将一个稀疏数组，转换为二维数组。
     */
    private static void fromSparseArrToTwoDimension(int[][] sparseArr) {
        int line = sparseArr[0][0];
        int row = sparseArr[0][1];

        int[][] twoDimension = new int[line][row];
        for (int i = 1; i < sparseArr.length; i++) {
            twoDimension[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        printTwoDimension(twoDimension);
    }

}