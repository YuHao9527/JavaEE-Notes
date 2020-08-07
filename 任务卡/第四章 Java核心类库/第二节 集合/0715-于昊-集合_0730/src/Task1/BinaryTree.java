package task.task1;

/**
 * @ClassName BinaryTree
 * @Description 二叉树
 * @Author 0715-YuHao
 * @Date 2020/7/30 14:53
 */
public class BinaryTree {

    //二叉树节点
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 1;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        preorderPrint(node);
        System.out.println();
        inOrderPrint(node);
        System.out.println();
        postOrderPrint(node);
    }

    /**
     * @Author 0715-YuHao
     * @Description 递归实现先序遍历
     * @Date 2020/7/30 15:01
     * @Param [root]
     * @return void
     */
    public static void preorderPrint(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "-");
            preorderPrint(root.left);
            preorderPrint(root.right);
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 递归实现中序遍历
     * @Date 2020/7/30 15:02
     * @Param []
     * @return void
     */
    public static void inOrderPrint(TreeNode root) {
        if (root != null) {
            inOrderPrint(root.left);
            System.out.print(root.val + "-");
            inOrderPrint(root.right);
        }
    }

    /**
     * @Author 0715-YuHao
     * @Description 递归实现后序遍历
     * @Date 2020/7/30 15:02
     * @Param []
     * @return void
     */
    public static void postOrderPrint(TreeNode root) {
        if (root != null) {
            postOrderPrint(root.left);
            postOrderPrint(root.right);
            System.out.print(root.val + "-");
        }
    }

}
