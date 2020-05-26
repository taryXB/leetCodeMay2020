/* Contiguous Array
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 */

class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int sum = 0;
        int N = nums.length;
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            if(nums[i] == 0) sum += -1;
            else sum += 1;
            if(sum == 0) {
                max = i + 1;
                continue;
            }
            if(map.containsKey(sum)){
                if(i - map.get(sum) > max){
                    max = i - map.get(sum);
                }
            }else{
                map.put(sum, i);
            }
        }
        return max;
    }
}

