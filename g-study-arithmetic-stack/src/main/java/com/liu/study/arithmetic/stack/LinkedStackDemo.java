package com.liu.study.arithmetic.stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Scanner;

/**
 * 使用链表实现stack的demo。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/8 22:31
 */
public class LinkedStackDemo {

    public static void main(String[] args) {

        // 这时候队列只能保存3个数据。
        SingleLinkedStack<String> singleLinkedStack = new SingleLinkedStack<String>();
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
                    String value = scanner.next();
                    try {
                        singleLinkedStack.push(value);
                    } catch (Exception e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                    break;

                case 'g':
                    try {
                        String queue = singleLinkedStack.pop();
                        System.out.println("获取的元素为：" + queue);
                    } catch (Exception e) {
                        System.out.println("异常：" + e.getMessage());
                    }
                    break;

                case 's':
                    singleLinkedStack.show();
                    break;

                default:
                    System.out.println("-----------------  无操作  -----------------");
                    return;
            }
        }
    }

    @Data
    static class SingleLinkedStack<T> {

        private int length = 0;

        private Node<T> head = new Node<>(null);

        /**
         * 是否为空
         * @return
         */
        public boolean isEmpty() {
            return head.next == null;
        }

        /**
         * 添加元素。
         */
        public void push(T value) {
            Node<T> node = new Node<>(value);

            if (head.next == null) {
                head.next = node;
            } else {
                Node<T> original = head.next;
                head.next = node;
                node.next = original;
            }
            length++;
        }

        /**
         * 获取值。
         */
        public void show() {
            Node<T> temp = head.next;
            int i = 1;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println("位置：" + i + " 值为：" +temp.toString());

                i++;
                length--;
                temp = temp.next;
            }
        }

        /**
         * 获取一个值。
         */
        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈中没有数据了~~~~~~~~~~");
            }

            Node<T> residue = head.next.next;
            Node<T> getData = head.next;
            getData.next = null;
            head.next = residue;
            return getData.getValue();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString(exclude = {
            "next"
    })
    static class Node<T> {

        private T value;

        private Node next;

        public Node(T value) {
            setValue(value);
        }
    }


}