package space.worldhu.practice;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hushicheng
 * @date 2020/7/21
 */
public class GenerateTrees {

    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     *
     *  
     *
     * 示例：
     *
     * 输入：3
     * 输出：
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * 解释：
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        for (int i = 0; i < treeNodes.size(); i++) {
            int deepth = getDeepth(treeNodes.get(i), 0);

        }
    }

    public static int getDeepth(TreeNode node, int deepth) {
        if (node == null) {
            return deepth;
        } else {
            deepth++;
        }
        int leftDeepth = getDeepth(node.left, deepth);
        int rightDeepth = getDeepth(node.right, deepth);
        return Math.max(leftDeepth, rightDeepth);
    }

    private static void printNode(TreeNode node, int deepth, int curDeepth) {
        if (node != null) {

            System.out.print(node.val);
            System.out.println();
            printNode(node.left, deepth, curDeepth++);
            printNode(node.right, deepth, curDeepth++);
        }
    }

    private static void printSpace(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(" ");
        }
    }


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}