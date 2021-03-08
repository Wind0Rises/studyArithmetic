package com.liu.study.arithmetic.linked;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

        deleteTest();
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