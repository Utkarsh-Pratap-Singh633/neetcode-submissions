class Solution {
    // Helper: given eating speed k, how many hours needed?
    static long hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int pile : piles) {
            // ceil(pile / k) using integer trick
            hours += (pile + k - 1) / k;
        }
        return hours;
    }
    
    static boolean isValidSolution(int[] piles, int h, int k) {
        return hoursNeeded(piles, k) <= h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;              // slowest possible speed (not 0! eating rate must be >=1)
        int e = 0;
        for (int pile : piles) {
            e = Math.max(e, pile);   // fastest USEFUL speed = biggest pile
        }
        
        int ans = e;  // fallback answer
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            
            if (isValidSolution(piles, h, mid)) {
                ans = mid;      // this speed works, remember it
                e = mid - 1;    // try slower
            } else {
                s = mid + 1;    // too slow, try faster
            }
        }
        
        return ans;
    }
}