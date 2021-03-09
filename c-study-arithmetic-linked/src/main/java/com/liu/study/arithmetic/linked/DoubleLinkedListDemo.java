package com.liu.study.arithmetic.linked;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 双向链表的Demo实现。
 *
 *  -------------           -------------           -------------
 *  |   head    |   ---->   |   first   |   <----   |   second  |
 *  |   head    |   <----   |   first   |   ---->   |   second  |
 *  -------------           -------------           -------------
 *
 *
 * TODO：待实现。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/8 21:22
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        // firstTest();

        // secondTest();

        updateTest();

    }

    public static void firstTest() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "宋江", "及时雨", null, null);
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "吴用", "智多星", null, null);
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "卢俊义", "玉麒麟", null, null);
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "林冲", "豹子头", null, null);
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.show();
        System.out.println();
        doubleLinkedList.deleteLast();
        doubleLinkedList.deleteLast();
        doubleLinkedList.deleteLast();
        doubleLinkedList.deleteLast();
        doubleLinkedList.deleteLast();
        doubleLinkedList.show();
    }

    /**
     * 按顺序添加
     */
    public static void secondTest() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "宋江", "及时雨", null, null);
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "吴用", "智多星", null, null);
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "卢俊义", "玉麒麟", null, null);
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "林冲", "豹子头", null, null);
        doubleLinkedList.sortAdd(heroNode2);
        doubleLinkedList.sortAdd(heroNode1);
        doubleLinkedList.sortAdd(heroNode4);
        doubleLinkedList.sortAdd(heroNode3);
        doubleLinkedList.show();

        doubleLinkedList.sortAdd(heroNode3);
    }

    /**
     * 更新操作。
     */
    public static void updateTest() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "宋江", "及时雨", null, null);
        DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "吴用", "智多星", null, null);
        DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "卢俊义", "玉麒麟", null, null);
        DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "林冲", "豹子头", null, null);
        doubleLinkedList.sortAdd(heroNode2);
        doubleLinkedList.sortAdd(heroNode1);
        doubleLinkedList.sortAdd(heroNode4);
        doubleLinkedList.sortAdd(heroNode3);
        doubleLinkedList.show();
        DoubleHeroNode heroNode11 = new DoubleHeroNode(2, "------- new 吴用 ----------", "111111智多星1111111", null, null);
        doubleLinkedList.updateNode(heroNode11);
        System.out.println();
        doubleLinkedList.show();
    }


    /**
     * 双向链表
     */
    static class DoubleLinkedList {

        private DoubleHeroNode head = new DoubleHeroNode(0, null, null, null, null);

        /**
         * 添加到双向链表。
         */
        public void add(DoubleHeroNode doubleHeroNode) {
            DoubleHeroNode temp = head;
            while (true) {
                if (null == temp.next) {
                    break;
                }
                temp = temp.next;
            }

            temp.next = doubleHeroNode;
            doubleHeroNode.prev = temp;
        }

        /**
         * 打印的
         */
        public void show() {
            if (null == head.next) {
                System.out.println("队列内容为空~~~~~~~~~~~~~");
                return;
            }

            DoubleHeroNode temp = head;
            while (true) {
                if (null == temp.next) {
                    break;
                }
                temp = temp.next;
                System.out.println(temp.toString());
            }
        }

        /**
         * 删除最后一个数据。
         */
        public void deleteLast() {
            if (null == head.next) {
                System.out.println("队列内容为空~~~~~~~~~~~~~");
                return;
            }

            DoubleHeroNode temp = head;
            while (true) {
                if (null == temp.next) {
                    temp.prev.next = null;
                    temp.prev = null;
                    break;
                }
                temp = temp.next;
            }
        }

        /**
         * 按顺序添加节点。
         * @param doubleHeroNode
         */
        public void sortAdd(DoubleHeroNode doubleHeroNode) {

            DoubleHeroNode temp = head;
            while (true) {
                if (null == temp.next) {
                    break;
                }
                if (doubleHeroNode.no <= temp.next.no) {
                    break;
                }
                temp = temp.next;
            }

            if (temp.next != null && doubleHeroNode.no == temp.next.no) {
                throw new RuntimeException("添加的节点已经存在~~~~~~~~~~~~~~~~~");
            }

            DoubleHeroNode next = temp.next;
            if (next != null) {
                doubleHeroNode.next = next;
                next.prev = doubleHeroNode;
            }
            temp.next = doubleHeroNode;
            doubleHeroNode.prev = temp;
        }

        /**
         * 根据编号查找，并修改节点。
         */
        public void updateNode(DoubleHeroNode newHeroNode) {
            DoubleHeroNode temp = head.next;

            boolean isCanUpdate = false;
            while (true) {
                if (null == temp) {
                    break;
                }

                if (temp.no == newHeroNode.no) {
                    isCanUpdate = true;
                    break;
                }

                temp = temp.next;
            }

            if (isCanUpdate) {
                temp.nickname = newHeroNode.nickname;
                temp.username = newHeroNode.username;
            } else {
                System.out.println("无节点，不能修改，节点编号为：{}" + newHeroNode.no);
            }
        }
    }

    /**
     *
     */
    @Data
    @ToString(exclude = {
            "next", "prev"
    })
    @NoArgsConstructor
    @AllArgsConstructor
    static class DoubleHeroNode {
        /** 排名 */
        private int no;

        /** 名称 */
        private String username;

        /** 外号 */
        private String nickname;

        /** 下一个节点 */
        private DoubleHeroNode next;

        /** 上一个接单 */
        private DoubleHeroNode prev;
    }


}