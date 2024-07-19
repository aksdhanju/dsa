package main.java.slidingwindow;

import java.util.HashMap;
import java.util.Map;

class SlidingWindow {
  public static void main(String[] args) {
    int[] nums = {1,1,1,7,8,9};
    int k = 3;
    long ans = maximumSubarraySum(nums, k);
    System.out.println(ans);
  }
  public static long maximumSubarraySum(int[] nums, int k) {
    int n = nums.length;
    int i = 0, j = 0;
    Long sum = 0L;
    Long maxSum = 0L;
    Map<Integer, Integer> map= new HashMap<>();
    while(j<n){
      map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
      sum += nums[j];
      if (j-i+1 < k){
        j++;
      } else if (j-i+1 == k){
        if (map.size()==k){
          if (sum > maxSum){
            maxSum = sum;
          }
        }
        map.put(nums[i], map.getOrDefault(nums[i], 0)-1);
        if (map.get(nums[i]).equals(0)){
          map.remove(nums[i]);
        }
        sum -= nums[i];
        i++;
        j++;
      }

    }
    return maxSum;
  }
}