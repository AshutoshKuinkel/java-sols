class Solution{
    public int findMin(int[] nums){

        int left = 0;
        int right = nums.length -1;
        int minSeenSoFar = nums[0];

        while(left<=right){
            if(nums[left]<nums[right]){
                minSeenSoFar = Math.min(minSeenSoFar,nums[left]);
            }

            int mid = left + (right-left)/2;

            minSeenSoFar = Math.min(minSeenSoFar,nums[mid]);

            if (nums[left]<=nums[mid]){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return minSeenSoFar;
    }
}