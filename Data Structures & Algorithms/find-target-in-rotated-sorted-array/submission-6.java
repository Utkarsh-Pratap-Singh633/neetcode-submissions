class Solution {

    static int findPivotIndex(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] >= nums[s]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return s;
    }

    static int binarySearch(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        if (n == 0) {
            return -1;
        }

        int pivotIndex = findPivotIndex(nums);

        // Search in left part
        if (target >= nums[0] && target <= nums[pivotIndex]) {
            return binarySearch(nums, 0, pivotIndex, target);
        }

        // Search in right part
        return binarySearch(nums, pivotIndex + 1, n - 1, target);
    }
}