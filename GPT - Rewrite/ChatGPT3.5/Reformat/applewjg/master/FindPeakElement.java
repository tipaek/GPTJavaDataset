public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1]))
                return mid;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            }
        }
        return mid;
    }
}
