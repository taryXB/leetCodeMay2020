/* Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 
 */
 

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int majority = 0;
        int freq = nums.length/2;;
        for(int x: nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            } else {
                map.put(x, 1);
            }
            if(map.get(x) > freq) {
                freq = map.get(x);
                majority = x;
                break;
            }
        }
        return majority;
    }
}

