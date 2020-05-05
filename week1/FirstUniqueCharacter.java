/* First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 
*/

class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        if(n==0) return -1;
        final int MAX = 26;
        int[] map = new int[MAX];
        
        for(int i = 0; i < n; i++) {
            map[s.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < n; i++) {
            if(map[s.charAt(i)-'a'] == 1) return i;
        }
        
        return -1;
    }
}

