package com.liu.study.arithmetic.stack;

import lombok.Data;
import lombok.ToString;

import java.util.Scanner;

/**
 * 栈的使用Demo
 *
 * 特点：
 *      * 先进后出
 *      * 栈顶变化，栈地不变。
 *      * 出栈（pop）、入栈（push）
 *
 *
 * 中缀表达式转后缀表达式。
 *
 * 栈使用的地方：
 *      二叉树的遍历。
 *      图形的深度优先搜索法。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/8 22:06
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        // 这时候队列只能保存3个数据。
        ArrayStack cyclicArray = new ArrayStack(3);
        System.out.println("a-->add添加元素");
        System.out.println("g-->get获取元素");
        System.out.println("s-->show打印元素");
        System.out.println("h-->head第一元素");
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("-----------------------------");
            System.out.print("请输入选择的操作：");
            char next = scanner.next().charAt(0);
            switch (next) {
                case 'a':
                    System.out.print("请输入要添加额值：");
                    int i = scanner.nextInt();
                    try {
                        cyclicArray.add(i);
                    } catch (Exception e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                    break;

                case 'g':
                    try {
                        int queue = cyclicArray.get();
                        System.out.println("获取的元素为：" + queue);
                    } catch (Exception e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                    break;

                case 's':
                    cyclicArray.show();
                    break;
                default:
                    System.out.println("-----------------  无操作  -----------------");
                    return;
            }
        }
    }

    /**
     *
     */
    @ToString(exclude = {
            "container"
    })
    @Data
    static class ArrayStack {

        /**
         * 最大尺寸
         */
        private int maxSize;

        /**
         * 执行栈顶的指针
         */
        private int stackTop = -1;

        /**
         * 内部容器。
         */
        private int[] container;

        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            container = new int[maxSize];
        }

        public boolean isFull() {
            return stackTop == maxSize - 1;
        }

        public boolean isEmpty() {
            return stackTop == -1;
        }

        public void add(int i) {
            if (isFull()) {
                throw new RuntimeException("超过最大限制~~~~~~~~~~~~");
            }

            stackTop++;

            container[stackTop] = i;
        }

        public void show() {
            for (int i = stackTop; i > -1; i--) {
                System.out.printf("位置：%d，值为：%d \n", maxSize - i, container[i]);
            }
        }

        public int get() {
            if (isEmpty()) {
                throw new RuntimeException("无数据~~~~~~~~~~~~");
            }

            int i = container[stackTop];
            stackTop--;
            return i;
        }

    }
}