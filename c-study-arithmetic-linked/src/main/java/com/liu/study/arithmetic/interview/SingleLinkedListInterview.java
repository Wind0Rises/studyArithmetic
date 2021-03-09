package com.liu.study.arithmetic.interview;

import com.liu.study.arithmetic.linked.DoubleLinkedListDemo;
import com.liu.study.arithmetic.linked.SingleLinkedListDemo;

/**
 * 链表面试题。
 *      1、获取单链表的节点的个数（如果带头节点的链表，需要不统计头节点。）
 *      2、查询单链表中的倒数第K个节点。
 *      3、单链表的翻转。
 *      4、从头到尾打印单链表。        -->     使用栈。
 *      5、合并两个有序的单链表，合并之后的链表依然有序。   TODO：
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/7 17:40
 */
public class SingleLinkedListInterview {

    public static void main(String[] args) {
        /**
         * 获取单链表的节点的个数（如果带头节点的链表，需要不统计头节点。）
         */
        // getSingleLinkedNodeCount();

        /**
         * 查询单链表中的倒数第K个节点。
         */
        // getBackwardsNode();

        /**
         * 单链表的翻转。
         */
        // singleLinkedInverse();

        /**
         * 从头到尾打印单链表。        -->     使用栈。
         */
        // singleLogInverse();
    }

    /**
     * 获取单链表的节点的个数（如果带头节点的链表，需要不统计头节点。）
     */
    public static void getSingleLinkedNodeCount() {
        SingleLinkedListDemo.getSingleLinkedNodeCount();
    }

    /**
     * 查询单链表中的倒数第K个节点。
     */
    public static void getBackwardsNode() {
        SingleLinkedListDemo.backwardsNode(2);
    }

    /**
     * 单链表的翻转。
     */
    public static void singleLinkedInverse() {
        SingleLinkedListDemo.inverseProcessor();
    }

    /**
     * 从头到尾打印单链表。        -->     使用栈。
     */
    public static void singleLogInverse() {
        SingleLinkedListDemo.logInverse();
    }


}