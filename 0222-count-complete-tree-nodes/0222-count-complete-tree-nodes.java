/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    // 왼쪽 끝으로만 내려가면서 높이 계산
    public int getHeight(TreeNode tree) {
        int h = 0;
        while (tree != null) {
            h++;
            tree = tree.left;
        }
        return h;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0; // 빈 트리 예외 처리

        int leftSubtreeHeight = getHeight(root.left);
        int rightSubtreeHeight = getHeight(root.right);

        // 왼쪽 서브트리 높이 == 오른쪽 서브트리 높이
        // → 왼쪽 서브트리가 포화 → 노드 수 = 2^leftH + 오른쪽 서브트리 노드 수
        if (leftSubtreeHeight == rightSubtreeHeight) {
            return (1 << leftSubtreeHeight) + countNodes(root.right);
        }
        // 왼쪽 높이 > 오른쪽 높이
        // → 오른쪽 서브트리가 포화 → 노드 수 = 2^rightH + 왼쪽 서브트리 노드 수
        else {
            return (1 << rightSubtreeHeight) + countNodes(root.left);
        }
    }
}