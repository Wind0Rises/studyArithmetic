package com.liu.study.arithmetic.structure.binary;

import java.util.Scanner;

/**
 * 二叉树：
 *      1.每个节点最多只有两个子节点。
 *
 * 满二叉树、完全二叉树
 * 顺序二叉树。
 *
 *
 * @author Liuweian
 * @createTime 2020/4/29 22:10
 * @version 1.0.0
 */
public class BinaryTree {

    /**
     * 通过前序遍历创建一棵二叉树。
     * @param node 相当而言的根节点。
     */
    public Node createTree(Node node) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入内容:");
        String readResult = scanner.nextLine();

        if (readResult.isEmpty()) {
            return null;
        } else {
            /** 如果输入不为空，将创建一个新的节点。 */
            Node newNode = new Node();

            /** 设置数据 */
            node.setData(readResult);
            /** 设置左子树 */
            node.setLeft(createTree(new Node()));
            /** 设置右子树 */
            node.setRight(createTree(new Node()));
        }

        return node;
    }

    /**
     * 遍历二叉树。
     *
     * @param tree
     * @param level
     */
    public void traverseBinaryTree(Node tree, int level) {
        if (tree != null) {
            System.out.println("第【" + level + "】层，数据为：" + tree.getData());
            traverseBinaryTree(tree.left, level + 1);
            traverseBinaryTree(tree.right, level + 1);
        }
    }

    /**
     * 树的节点。
     */
    static class Node {
        private String data;

        private Node left;

        private Node right;

        public Node() {

        }

        public Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
