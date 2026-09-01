class Solution {
    static boolean isValidSolution(int[] nums , int k , int maxLength){
         int firstSum = 1;
         int totalLength = 0;
         for(int  i = 0; i < nums.length; i++){
            if(totalLength + nums[i] <= maxLength){
                totalLength = totalLength + nums[i];
            }
            else{
                firstSum++;
                totalLength = 0;
                if(firstSum > k || nums[i]> maxLength){
                    return false;
                }
                else{
                    totalLength = totalLength + nums[i];
                }
            }
        }

        return true;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int s = 0;
        int e = sum;
        int ans = -1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(isValidSolution(nums , k , mid)){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }
}