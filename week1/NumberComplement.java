/* Number Complement
 *
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 */

class Solution {
    public int findComplement(int num) {   
        int temp = num;
        int count = 0;
        while(temp>0){
            temp = temp >> 1;
            count++;
        }
        return ((1<<count) - 1) ^ num;
    }
}
