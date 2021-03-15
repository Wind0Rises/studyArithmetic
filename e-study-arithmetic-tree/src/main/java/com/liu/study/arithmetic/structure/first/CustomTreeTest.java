package com.liu.study.arithmetic.structure.first;

/**
 * 尚学堂学习数据结构测试。
 *
 *
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2021/3/15 12:35
 */
public class CustomTreeTest {

    /**
     *                  root(1)
     *                  /  \
     *                 /    \
     *               2       3
     *                      / \
     *                     /   \
     *                    5     4
     *
     * 前序遍历：1 - 2 - 3 - 5 - 4
     * 中序遍历：2 - 1 - 5 - 3 - 4
     * 后序遍历：2 - 5 - 4 - 3 - 1
     *
     * @param args
     */
    public static void main(String[] args) {
        HeroObject heroObject1 = new HeroObject(1, "宋江", "及时雨");
        HeroObject heroObject2 = new HeroObject(2, "林冲", "豹子头");
        HeroObject heroObject3 = new HeroObject(3, "卢俊义", "玉麒麟");
        HeroObject heroObject4 = new HeroObject(4, "吴用", "智多星");
        HeroObject heroObject5 = new HeroObject(5, "鲁智深", "花和尚");

        CustomTree.TreeNode<HeroObject> root = new CustomTree.TreeNode<>(heroObject1);
        CustomTree.TreeNode<HeroObject> node2 = new CustomTree.TreeNode<>(heroObject2);
        CustomTree.TreeNode<HeroObject> node3 = new CustomTree.TreeNode<>(heroObject3);
        CustomTree.TreeNode<HeroObject> node4 = new CustomTree.TreeNode<>(heroObject4);
        CustomTree.TreeNode<HeroObject> node5 = new CustomTree.TreeNode<>(heroObject5);

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);


        CustomTree<HeroObject> customTree = new CustomTree<>();
        customTree.setRoot(root);


        /**
         * 遍历测试，
         */
        // traverse(customTree);

        /**
         * 查询测试。
         */
        query(customTree, heroObject4);

    }

    /**
     * 遍历
     *
     * @param customTree
     */
    private static void traverse(CustomTree<HeroObject> customTree) {
        customTree.preorderTraverse();

        System.out.println("\n");

        customTree.inorderTraverse();

        System.out.println("\n");

        customTree.postOrderTraverse();
    }

    /**
     * 查找。
     *
     * @param customTree
     */
    private static void query(CustomTree<HeroObject> customTree, HeroObject target) {
        final HeroObject heroObject = customTree.preorderQuery(target);
        System.out.println("【前】序查找返回的数据为：" + heroObject);

        final HeroObject in = customTree.inorderQuery(target);
        System.out.println("【中】序查找返回的数据为：" + in);

        final HeroObject post = customTree.postOrderQuery(target);
        System.out.println("【后】序查找返回的数据为：" + post);

    }

}
