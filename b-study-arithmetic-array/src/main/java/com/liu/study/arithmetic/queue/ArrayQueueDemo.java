package com.liu.study.arithmetic.queue;

import java.util.Scanner;

/**
 * 使用数组实现队列操作。
 *
 * <note>
 *     问题：数组不能循环使用；可以使用环形数组
 * </note>
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/6 16:22
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                        arrayQueue.addQueue(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.println("获取的元素为：" + queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 's':
                    arrayQueue.showQueue();
                    break;
                    
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("头节点为:" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("-----------------  无操作  -----------------");
                    return;
            }
        }
    }

    /**
     * 空                                    添加元素                              获取元素
     * ——————————                           ——————————                          ——————————
     * |        |                           |        |                          |        |
     * ——————————                           ——————————                          ——————————
     * |        |                           |        |                          |        |
     * ——————————                           ——————————                          ——————————
     * |        |               ====>       | 有元素  |  rear = 2;               | 有元素  |       rear = 2;
     * ——————————                           ——————————                          ——————————
     * |        |                           | 有元素  |                          | 有元素  |       front = 0；
     * ——————————                           ——————————                          ——————————
     * |        |                           | 有元素  |                          |        |
     * ——————————                           ——————————                          ——————————
     * rear == front == -1
     */
    static class ArrayQueue {

        /**
         * 队列列中最多有多少个元素。
         */
        int maxSize;

        /**
         * 队列头位置；内部数组第一个位置 减 1;
         *
         * <note>
         *     每获取一个元素，需要加1。
         * </note>
         *
         */
        int front;

        /**
         * 队列尾：
         *
         * <note>
         *     每添加一个元素，需要加1；
         * </note>
         */
        int rear;

        /**
         *
         */
        int[] array;

        /**
         *
         */
        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            array = new int[maxSize];
            front = -1;
            rear = -1;
        }

        /**
         * 判断是否为空。
         *
         * @return
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * 判断队列是否满了。
         *
         * @return
         */
        public boolean isFull() {
            return rear == maxSize -1;
        }

        /**
         * 添加元素。
         *
         * @param element
         * @throws Exception
         */
        public void addQueue(int element) throws Exception {
            if (isFull()) {
                throw new Exception("队列已经满了，不能加入数据~~~~~~~~~~~~");
            }

            rear++;

            array[rear] = element;
        }

        /**
         * 获取数据
         */
        public int getQueue() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列空了，无数据可以提取~~~~~~~~~~~~");
            }

            front++;

            return array[front];
        }

        /**
         * 打印队列
         */
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列为空，没有数据~~~~~");
            }

            for (int i = 0; i < array.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, array[i]);
            }
        }



        /**
         *
         * @return
         * @throws Exception
         */
        public int headQueue() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列空了，无数据可以提取~~~~~~~~~~~~");
            }

            return array[front + 1];
        }

    }
}