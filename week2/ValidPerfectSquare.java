/* Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true

Example 2:

Input: 14
Output: false


 */

class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        
        int low = 1;
        int high = num/2;
        int mid = 0;
        long square = 0;
        while(low <= high){
            mid = low + (high-low)/2;
            square = (long) mid * mid;
            if(square == num) 
                return true;
            else if(square < num) 
                low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
