package com.liu.study.arithmetic.linked;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Stack;

/**
 * 单链表：
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/7 15:28
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) throws Exception {

        // addTest();

        // addSortForHeroNoTest();

        // updateTest();

        // deleteTest();

        // getSingleLinkedNodeCount();

        // backwardsNode(4);

        // inverseProcessor();

        logInverse();
    }

    /**
     * 按顺序插入测试。
     * @return
     */
    private static void addSortForHeroNoTest() throws Exception {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟", null);
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头", null);

        singleLinkedList.addSortForHeroNo(heroNode2);
        singleLinkedList.addSortForHeroNo(heroNode1);
        singleLinkedList.addSortForHeroNo(heroNode4);
        singleLinkedList.addSortForHeroNo(heroNode3);

        singleLinkedList.showLinked();

        singleLinkedList.addSortForHeroNo(heroNode1);
    }

    /**
     * add操作测试。
     * @return
     */
    private static void addTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟", null);
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头", null);

        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        singleLinkedList.showLinked();
    }

    public static void updateTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟", null);
        HeroNode newHeroNode2 = new HeroNode(2, "新吴用", "-----------智多星---------", null);

        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.updateNode(newHeroNode2);

        singleLinkedList.showLinked();
    }

    /**
     * 删除测试。
     */
    public static void deleteTest() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟", null);

        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);

        singleLinkedList.delete(heroNode2);

        singleLinkedList.showLinked();
    }

    /**
     * 获取单链表的节点个数。
     */
    public static void getSingleLinkedNodeCount() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟", null);

        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);

        System.out.println(singleLinkedList.getCount());
    }

    /**
     *
     * @param k
     */
    public static void backwardsNode(int k) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟", null);
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头", null);

        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        singleLinkedList.backwardsNode(k);
    }

    /**
     * 反转操作。
     */
    public static void inverseProcessor() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟", null);
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头", null);

        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        singleLinkedList.showLinked();

        singleLinkedList.inverse();
        System.out.println();
        singleLinkedList.showLinked();
    }

    /**
     * 反转打印
     */
    public static void logInverse() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨", null);
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星", null);
        HeroNode heroNode3 = new HeroNode(3, "卢俊义", "玉麒麟", null);
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头", null);

        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        singleLinkedList.logInverse();



    }






    /**
     * 链表
     */
    private static class SingleLinkedList {
        /**
         * 头结点不放任何元素。用于标记类。
         */
        HeroNode head = new HeroNode(0, "", "", null);

        /**
         * 添加元素。
         *
         * @param heroNode
         */
        public void add(HeroNode heroNode) {
            HeroNode temp = head;
            while (true) {
                if (null == temp.next) {
                    break;
                }

                temp = temp.next;
            }

            temp.next = heroNode;
        }

        /**
         * 按顺序插入节点。
         *
         * @param heroNode
         * @throws Exception
         */
        public void addSortForHeroNo(HeroNode heroNode) throws Exception {
            HeroNode insertFrontElement = head;
            while (true) {
                if (insertFrontElement.next == null) {
                    break;
                }

                if (heroNode.no <= insertFrontElement.next.no) {
                    break;
                }

                insertFrontElement = insertFrontElement.next;
            }

            if (null != insertFrontElement.next) {
                if (heroNode.no == insertFrontElement.next.no) {
                    throw new Exception("元素已经存在，不能重复插入：" + heroNode.no);
                }
                heroNode.next = insertFrontElement.next;
            }
            insertFrontElement.next = heroNode;
        }

        /**
         * 打印链表。
         */
        public void showLinked() {
            if (null == head.next) {
                System.out.println("链表不存在数据~~~~~~~~~~~");
                return;
            }

            HeroNode temp = head;
            while (true) {
                if (null == temp.next) {
                    break;
                }

                temp = temp.next;
                System.out.println(temp.toString());
            }
        }

        /**
         * 根据编号查找，并修改节点。
         */
        public void updateNode(HeroNode newHeroNode) {
            HeroNode temp = head.next;

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

        /**
         * 删除节点
         *
         * @param heroNode
         */
        public void delete(HeroNode heroNode) {
            HeroNode temp = head;
            boolean isCanDelete = false;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (heroNode == temp.next) {
                    isCanDelete = true;
                    break;
                }
                temp = temp.next;
            }

            if (isCanDelete) {
                if (null != heroNode.next.next) {
                   temp.next = null;
                } else {
                    temp.next = temp.next.next;
                }
            } else {
                System.out.println("要删除的元素不存在。");
            }

        }


        /**
         * 获取节点的个数。
         * @return
         */
        public int getCount() {
            if (null == head.getNext()) {
                return 0;
            }

            HeroNode temp = head.getNext();
            int i = 1;
            while (true) {
                if (null == temp.getNext()) {
                    break;
                }
                i++;
                temp = temp.getNext();
            }
            return i;
        }


        /**
         *
         * @param k
         */
        public void backwardsNode(int k) {
            final int count = getCount();
            if (k > count || k < 0) {
                throw new RuntimeException("数据异常");
            }

            HeroNode heroNode = head.getNext();
            for (int i = 0; i < count - k; i++) {
                heroNode = heroNode.getNext();
            }
            System.out.println(heroNode.toString());
        }



        /**
         * 单链表反转。
         *
         * --------         --------            ----------            --------
         * | head |  -->    | first |    -->    | second |     -->   | three |
         * --------         --------            ----------            --------
         *
         * 第一步：创建一个新的头节点，
         * -----------
         * | newHead |
         * -----------
         *
         * 第二步：把第一个节点取下来，并放在newHead后面。
         * ----------           ---------           ----------           ---------
         * | newHead |  -->     | first |    -->    | second |     -->   | three |
         * ----------           ---------           ----------          ---------
         *
         * 第三步：把第二个节点取下来，并放在newHead后面、first前面
         * ----------           ---------           ----------
         * | newHead |  -->     | second |    -->   | first  |
         * ----------           ---------           ----------
         *
         *
         * 最后步：把head节点的next指向新链表的第一个
         * ----------        ---------          ---------           ----------
         * | newHead |  -->  | three |   -->   | second |    -->    | first  |
         * ----------        ---------          ---------           ----------
         *                       ↑
         *                       |
         *                   -----------
         *                   | newHead |
         *                   -----------
         *
         */
        public void inverse() {
            if (head.getNext() == null) {
                throw new RuntimeException("数据为空~~~~~~~~~");
            }

            HeroNode newHead = new HeroNode();
            while (true) {
                if (null == head.next) {
                    break;
                }

                if (newHead.next == null) {
                    HeroNode heroNode = head.next;
                    newHead.next = heroNode;
                    head.next = head.next.next;
                    heroNode.next = null;
                    continue;
                }

                HeroNode heroNode = head.next;
                head.next = head.next.next;

                HeroNode newHeadNext = newHead.next;
                newHead.next = heroNode;
                heroNode.next = newHeadNext;
            }

            head.next = newHead.next;
        }

        /**
         * 倒叙打印
         */
        public void logInverse() {
            HeroNode temp = head;

            Stack<HeroNode> stack = new Stack<HeroNode>();
            while (true) {

                if (null == temp.next) {
                    break;
                }

                stack.push(temp.next);
                temp = temp.next;
            }

            while (!stack.empty()) {
                System.out.println(stack.pop().toString());
            }
        }

    }



    /**
     * 梁山英雄节点。
     *
     *
     * @author lwa
     * @createTime 2021/3/7 15:35
     * @version 1.0.0
     */
    @Data
    @ToString(exclude = {
           "next"
    })
    @NoArgsConstructor
    @AllArgsConstructor
    private static class HeroNode {
        /** 排名 */
        private int no;

        /** 名称 */
        private String username;

        /** 外号 */
        private String nickname;

        /** 下一个节点 */
        private HeroNode next;
    }

}