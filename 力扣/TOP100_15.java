package 力扣;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TOP100_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum > 0) R--;
                else if (sum < 0) L++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int []nums={-1,0,1,2,-1,-4};
        TOP100_15 m=new TOP100_15();
        System.out.println(m.threeSum(nums));
    }
}
