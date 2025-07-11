class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 항상 nums1이 짧은 배열이 되도록 스왑        
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length ,n = nums2.length;
        int left = 0, right = m;
        int k = (m + n + 1) / 2; // 왼쪽 파티션에 들어가야 할 총 개수
        

        while(left <= right){
            int mid = left + (right - left) / 2;// nums1에서 고를 개수
            int j = k - mid;                    // nums2에서 고를 개수
            int maxLeft1, maxLeft2, minRight1, minRight2;
            
            // 경계값 처리
            if(mid == 0){
                 maxLeft1 = Integer.MIN_VALUE;
            }else{
                 maxLeft1 = nums1[mid-1];
            }

            if(mid == m){
                 minRight1 = Integer.MAX_VALUE;
            }else{
                 minRight1 = nums1[mid];
            }

            if(j == 0){
                 maxLeft2 = Integer.MIN_VALUE;
            }else{
                 maxLeft2 = nums2[j-1];
            }

            if(j == n){
                 minRight2 = Integer.MAX_VALUE;
            }else{
                 minRight2 = nums2[j];
            }

             // 올바른 파티션인 경우 → 중간값 계산
            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((m+n)%2==0){
                    // 짝수 → 중앙 두 개의 평균
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1,minRight2)) /2.0;
                }else{
                    // 홀수 → 왼쪽 파티션의 최대값
                    return Math.max(maxLeft1, maxLeft2);
                }
            }else if(maxLeft1 > minRight2){
                // nums1 쪽 파티션을 왼쪽으로 이동
                right = mid - 1;
            }else{
                // nums1 쪽 파티션을 오른쪽으로 이동
                left = mid + 1;
            }
        }
         // 로직상 도달하지 않아야 하지만, 예외 방지를 위해
        throw new IllegalArgumentException("Input arrays are not sorted properly");
    }
}