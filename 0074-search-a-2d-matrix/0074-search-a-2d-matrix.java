class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, cols = matrix[0].length;
        int left = 0, right = row * cols - 1;
        while(left <= right ){
            int mid = left + (right - left) / 2;
            int midval = matrix[mid / cols][mid % cols];

            if(midval == target){
                return true;
            }
            if(midval > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}