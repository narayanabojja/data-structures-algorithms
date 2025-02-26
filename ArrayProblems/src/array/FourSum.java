package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums and an integer target. Return all quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * · a, b, c, d are all distinct valid indices of nums.
 * 
 * · nums[a] + nums[b] + nums[c] + nums[d] == target. Time Complexity:O(n log n)
 * for sorting + O(n^3) for the nested loops and two-pointer approach, resulting
 * in O(n^3) Space Complexity:O(1) excluding the space for the answer, O(n)
 * including the space for sorting
 */
public class FourSum {

	public static void main(String[] args) {
		int[] nums = { 2,2,2,2,2 };
		System.out.println(fourSum(nums, 8));
	}

	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> li = new ArrayList<>();
	        if (nums == null || nums.length < 4) {
	            return li;
	        }
	        Arrays.sort(nums);
	        for (int i = 0; i < nums.length - 3; i++) {
	            if (i > 0 && nums[i] == nums[i - 1]) {
	                continue;
	            }
	            for (int j = i + 1; j < nums.length - 2; j++) {
	                if (j > i + 1 && nums[j] == nums[j - 1]) {
	                    continue;
	                }
	                int left = j + 1;
	                int right = nums.length - 1;
	                while (left < right) {
	                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
	                    if (sum == target) {
	                        li.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
	                        while (left < right && nums[left] == nums[left + 1]) {
	                            left++;
	                        }
	                        while (left < right && nums[right] == nums[right + -1]) {
	                            right--;
	                        }
	                        left++;
	                        right--;
	                    } else if (sum < target) {
	                        left++;
	                    } else {
	                        right--;
	                    }
	                }
	            }
	        }
	        return li;
	    }
}
