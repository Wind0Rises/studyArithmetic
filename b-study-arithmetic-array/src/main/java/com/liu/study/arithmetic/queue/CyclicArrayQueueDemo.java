package com.liu.study.arithmetic.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/7 14:11
 */
public class CyclicArrayQueueDemo {

    public static void main(String[] args) throws Exception {

        // 这时候队列只能保存3个数据。
        CyclicArray cyclicArray = new CyclicArray(3);
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
                        cyclicArray.addQueue(i);
                    } catch (Exception e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                    break;

                case 'g':
                    try {
                        int queue = cyclicArray.getQueue();
                        System.out.println("获取的元素为：" + queue);
                    } catch (Exception e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                    break;

                case 's':
                    cyclicArray.showQueue();
                    break;

                case 'h':
                    try {
                        int head = cyclicArray.headQueue();
                        System.out.println("头节点为:" + head);
                    } catch (Exception e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("-----------------  无操作  -----------------");
                    return;
            }
        }
    }

    static class CyclicArray {
        /**
         * <note>
         * 实际数组的长度：maxSize - 1;
         * </note>
         */
        int maxSize;

        /**
         * 队列头位置；内部数组第一个位置 减 1;
         *
         * <note>
         * 执行第一个元素的位置。
         * </note>
         */
        int front;

        /**
         * 队列尾：
         *
         * <note>
         * 执行队列最后一个元素的下一个位置。
         * </note>
         */
        int rear;

        /**
         * <note>
         *     实际使用的位置为 maxSize - 1；
         *     创建一个int[5]的数组，实际使用的是前四个位置。
         * </note>
         */
        int[] array;

        CyclicArray(int maxSize) {
            this.maxSize = maxSize + 1;
            array = new int[maxSize + 1];
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
            return (rear + 1) % maxSize == front;
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

            array[rear] = element;

            rear = (rear + 1) % maxSize;
        }

        /**
         * 获取数据
         */
        public int getQueue() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列空了，无数据可以提取~~~~~~~~~~~~");
            }

            int value = array[front];
            front = (front + 1) % maxSize;
            return value;
        }

        /**
         * 打印队列
         */
        public void showQueue() {
            if (isEmpty()) {
                System.out.println("队列为空，没有数据~~~~~");
            }

            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, array[i % maxSize]);
            }
        }

        /**
         * 数据的个数。
         */
        private int size() {
            return (rear + maxSize - front) % maxSize;
        }

        /**
         * @return
         * @throws Exception
         */
        public int headQueue() throws Exception {
            if (isEmpty()) {
                throw new Exception("队列空了，无数据可以提取~~~~~~~~~~~~");
            }

            return array[front];
        }

        @Override
        public String toString() {
            return "maxSize=" + maxSize +
                    ", front（前）=" + front +
                    ", rear（后）=" + rear +
                    ", array=" + Arrays.toString(array) +
                    '}';
        }
    }
}

