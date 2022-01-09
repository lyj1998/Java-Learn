import java.util.*;

class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            if (nums[i] > 0) {
                return res;
            }
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }
                if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }
            }
        }
        res.addAll(set);
        return res;
    }
}