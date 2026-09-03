class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int s = 1;
        int maxi = 0;
        for(int i = 0; i < n; i++){
            if(maxi < piles[i]){
                maxi = piles[i];
            }
        }
        int e = maxi;
        int ans = 0;

        while (s<=e){
            int mid = s + (e-s)/2;
            long bananaCount = 0;
            for(int i =0; i <piles.length; i++){
                bananaCount += (piles[i] + mid -1)/mid;
            }
            if(bananaCount <= h){
                ans = mid;
                e = mid - 1;
            }
            else{
                s = mid + 1 ;
            }
        }
        return ans;
    }
}
