class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, window =0, ans = n+1, left =0;
        for(int r=0; r<n; r++){
            window += nums[r];
            while(window >= target){
                ans = Math.min(ans, r-left+1);
                window -= nums[left++];
            }
        }
        return ans == n+1 ? 0 :ans;
        
    }
}