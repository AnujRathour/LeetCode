// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

public class Main {
        public boolean check(int[] nums) {
            int n=nums.length;
            int count=0;
            for(int i=0;i<n-1;i++){
                if(nums[i]>nums[i+1]) count++;

            }

            if(count==0) return true;
            if(count==1&&nums[0]>=nums[n-1]) return true;
            return false;
        }

}