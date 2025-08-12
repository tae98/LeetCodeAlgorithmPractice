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
    public int countNodes(TreeNode root) {
        int left = 0, h = 0;
        TreeNode node = root;
        while(node != null){
            h++;
            node = node.left;
        }
        if (h == 0){
            return 0;} 
        else if(h == 1){
            return 1;
        }

        int right = (1 << (h -1)) - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(exists(mid, h, root)){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return ((1 << (h - 1)) - 1) + left;
    }

    // Solution 클래스 내부에 추가
    private boolean exists(int idx, int h, TreeNode node) {
        // 마지막 레벨의 이진탐색 구간
        int left = 0, right = (1 << (h - 1)) - 1;

        // 위에서 아래로 (h-1)층 내려가며 경로 확인
        for (int i = h - 2; i >= 0 && node != null; i--) {
            int mid = left + (right - left) / 2;
            if (idx <= mid) { // 왼쪽 절반이면 왼쪽 자식
                node = node.left;
                right = mid;
            } else { // 오른쪽 절반이면 오른쪽 자식
                node = node.right;
                left = mid + 1;
            }
        }
        return node != null; // 끝까지 내려가서 null 아니면 존재
    }
}