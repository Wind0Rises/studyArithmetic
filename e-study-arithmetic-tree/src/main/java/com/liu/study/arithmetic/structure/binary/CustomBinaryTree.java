package com.liu.study.arithmetic.structure.binary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

/**
 * 自定义二叉树。
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/9/29 13:39
 */
public class CustomBinaryTree {

    public Node createTree() {
        return createTree(new Node());
    }


    public Node createTree(Node node) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入内容:");
        String readResult = scanner.nextLine();

        if (StringUtils.isEmpty(readResult)) {
            return node;
        } else {
            if (StringUtils.isEmpty(node.data)) {
                node.setData(readResult);
                createTree(node);
            }



            Integer currentNodeData = Integer.valueOf(node.getData());
            Integer readResultInteger = Integer.valueOf(readResult);
            if (readResultInteger > currentNodeData) {
                node.setRight(new Node(String.valueOf(readResultInteger)));
            } else {
                node.setLeft(new Node(String.valueOf(readResultInteger)));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        new CustomBinaryTree().createTree();
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Node {

        private String data;

        Node(String data) {
            this.data = data;
        }

        private Node left;

        private Node right;
    }

}