package com.liu.study.arithmetic.classic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 约瑟夫问题：
 *      一个群人围成一个圈，依次报数，当报到M时，这个M出去，从下一重新报数。
 *
 * 单向环形列表；也可以使用数组取模的方式。
 *
 *
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/8 21:30
 */
public class JosephProblemDemo {


    public static void main(String[] args) {
        CircleSingleLinked circleSingleLinked = new CircleSingleLinked();
        circleSingleLinked.createCircleSingleLinked(5);
        circleSingleLinked.show();
        circleSingleLinked.josephProblem(1, 3);
    }



    static class CircleSingleLinked {

        private CircleHeroNode first = null;

        public CircleSingleLinked() {

        }

        /**
         * 创建一个环。
         * @param count
         */
        public void createCircleSingleLinked(int count) {
            if (count < 1) {
                throw new RuntimeException("传入参数错误~~~~~");
            }

            CircleHeroNode temp = null;
            for (int i = 1; i <= count; i++) {
                CircleHeroNode node = new CircleHeroNode(i, null);

                if (i == 1) {
                    node.next = node;
                    first = node;
                } else {
                    temp.next = node;
                    node.next = first;
                }

                temp = node;
            }
        }

        /**
         * 展示
         */
        public void show() {
            if (first == null) {
                throw new RuntimeException("暂无数据");
            }

            CircleHeroNode temp = first;
            while (true) {
                System.out.println(temp.toString());
                if (temp.getNext() == first) {
                    break;
                }
                temp = temp.next;
            }
        }

        /**
         *
         * @param start
         * @param step
         */
        public void josephProblem(int start, int step) {
            if (null == first) {
                throw new RuntimeException("暂无数据");
            }

            // 01、查询first的上一个位置。
            CircleHeroNode temp = first;
            CircleHeroNode startNode = first;
            while (true) {
                if (temp.getNext() == first) {
                    break;
                }
                temp = temp.next;
            }

            // 02、移动到开始的位置。
            for (int i = 1; i < start; i++) {
                temp = temp.getNext();
                startNode = startNode.getNext();
            }

            // 03、
            while (true) {
                if (temp == startNode) {
                    System.out.println("----" + temp.getNo());
                    break;
                }

                for (int i = 1; i < step; i++) {
                    temp = temp.getNext();
                    startNode = startNode.getNext();
                }

                temp.next = startNode.getNext();
                System.out.println("----" + startNode.getNo());
                startNode = startNode.getNext();
            }
        }

    }

    @Data
    @ToString(exclude = {
            "next"
    })
    @NoArgsConstructor
    @AllArgsConstructor
    static class CircleHeroNode {
        /**
         * 编号。
         */
        private int no;

        /**
         * 下一个节点。
         */
        private CircleHeroNode next;
    }

}