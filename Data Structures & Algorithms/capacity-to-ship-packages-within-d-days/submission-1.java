class Solution {
    static boolean isValidSolution(int [] weights , int days,  int maxDays){
        int dayCount = 1;
        int totalLength = 0;
        for(int i= 0; i<weights.length; i++){
            if(totalLength + weights[i] <= maxDays){
                totalLength = totalLength + weights[i];
            }
            else{
                dayCount++;
                totalLength = 0;
                if(dayCount > days || weights[i] > maxDays){
                    return false;
                }
                else{
                    totalLength = totalLength + weights[i];
                }
            }
        }

        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += weights[i];
        }
        int s = 0;
        int e = sum;
        int ans = -1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(isValidSolution(weights , days , mid)){
                ans = mid;
                e = mid -1;
            }
            else{
                s = mid + 1;
            }
        }
        return ans;
    }
}