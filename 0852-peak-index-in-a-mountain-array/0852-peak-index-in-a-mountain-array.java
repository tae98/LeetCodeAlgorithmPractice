class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            // 피크는 mid 혹은 그 왼쪽에 있음
            if(arr[mid] > arr[mid+1]){
                right =  mid;
            // 피크는 무조건 mid 오른쪽에 있음
            }else if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            }
        }
        return left; // 또는 right (같은 값)
    }
}