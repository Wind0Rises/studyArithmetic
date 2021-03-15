package com.liu.study.arithmetic.structure.first;

import lombok.Data;

/**
 * 学习视频地址：https://www.bilibili.com/video/BV1E4411H73v?p=94&spm_id_from=pageDriver
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/15 9:19
 */
public class CustomTree<T> {

    private TreeNode<T> root;

    public CustomTree() {

    }

    /**
     * 设置根节点。
     * @param root
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }


    // ###################################
    // #                遍历              #
    // ###################################
    /**
     * 前序遍历
     */
    public void preorderTraverse() {
        if (null == root) {
            System.out.println("=====  没有数据  =====");
            return;
        }

        root.preorderTraverse();
    }

    /**
     * 中序遍历
     */
    public void inorderTraverse() {
        if (null == root) {
            System.out.println("=====  没有数据  =====");
            return;
        }

        root.inorderTraverse();
    }

    /**
     * 后序遍历
     */
    public void postOrderTraverse() {
        if (null == root) {
            System.out.println("=====  没有数据  =====");
            return;
        }

        root.postOrderTraverse();
    }

    // ###################################
    // #                查找              #
    // ###################################

    /**
     * 前序查找
     *
     * @param no
     * @return
     */
    public T preorderQuery(T no) {
        T result = root.preorderQuery(no);
        return result;
    }

    /**
     * 中序查找
     *
     * @param no
     * @return
     */
    public T inorderQuery(T no) {
         T result = root.inorderQuery(no);
         return result;
    }

    /**
     * 后序查找
     * @param no
     * @return
     */
    public T postOrderQuery(T no) {
        final T result = root.postOrderQuery(no);
        return result;
    }


    @Data
    static class TreeNode<T> {

        private T data;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(T t) {
            this.data = t;
        }

        // ###################################
        // #                遍历              #
        // ###################################
        /**
         * 前序遍历。
         */
        public void preorderTraverse() {
            System.out.println(this.data.toString());

            if (null != this.left) {
                this.left.preorderTraverse();
            }

            if (null != this.right) {
                this.right.preorderTraverse();
            }
        }

        /**
         * 中序遍历
         */
        public void inorderTraverse() {
            if (null != this.left) {
                this.left.inorderTraverse();
            }

            System.out.println(this.data.toString());

            if (null != this.right) {
                this.right.inorderTraverse();
            }
        }

        /**
         * 后序遍历
         */
        public void postOrderTraverse() {
            if (null != this.left) {
                this.left.postOrderTraverse();
            }

            if (null != this.right) {
                this.right.postOrderTraverse();
            }

            System.out.println(this.data.toString());
        }

        // ###################################
        // #                遍历              #
        // ###################################
        /**
         * 前序遍历。
         */
        public T preorderQuery(T no) {
            if (this.data == no) {
                System.out.println(this.data.toString());
                return this.data;
            }

            T result = null;
            if (null != this.left) {
                result = (T) this.left.preorderQuery(no);
            }

            if (null != this.right) {
                result = (T) this.right.preorderQuery(no);
            }
            return result;
        }

        /**
         * 中序遍历。
         */
        public T inorderQuery(T no) {
            T result = null;
            if (null != this.left) {
                result = (T) this.left.inorderQuery(no);
            }

            if (result != null) {
                return result;
            }

            if (this.data == no) {
                System.out.println(this.data.toString());
                return this.data;
            }

            if (null != this.right) {
                result = (T) this.right.inorderQuery(no);
            }
            return result;
        }

        /**
         * 前序遍历。
         */
        public T postOrderQuery(T no) {

            T result = null;
            if (null != this.left) {
                result = (T) this.left.preorderQuery(no);
            }

            if (null != this.right) {
                result = (T) this.right.preorderQuery(no);
            }

            if (null != result) {
                return result;
            }

            if (this.data == no) {
                System.out.println(this.data.toString());
                return this.data;
            }

            return result;
        }

    }

}
