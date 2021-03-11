package com.liu.study.arithmetic.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 自定义栈实现。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/11 9:15
 */
public class CustomStack<T> {

    // TODO:如果设置了最大长度，

    /**
     * 长度；
     */
    private int length = 0;

    private Node<T> head = new Node<>(null);


    /**
     * 是否为空
     *
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
            System.out.println("位置：" + i + " 值为：" + temp.toString());

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

    /**
     * 查看
     * @return
     */
    public T peep() {
        if (isEmpty()) {
            throw new RuntimeException("栈中没有数据了~~~~~~~~~~");
        }

        Node<T> first = head.next;
        return first.value;
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

