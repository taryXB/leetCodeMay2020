/* Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        List<Integer> ar = new ArrayList<>();   
        if(sl<pl) return ar;
        char[] sHash = new char[26];
        char[] pHash = new char[26];       
        for(int i = 0; i < pl; i++) {
            (sHash[s.charAt(i)-'a'])++;
            (pHash[p.charAt(i)-'a'])++;
        }       
        for(int i = pl; i < sl; i++) {
            if(Arrays.equals(sHash,pHash)) {
                ar.add(i-pl);
            }
            (sHash[s.charAt(i)-'a'])++;
            (sHash[s.charAt(i-pl)-'a'])--;
        }
        if(Arrays.equals(sHash,pHash)) {
                ar.add(sl-pl);
        }
        return ar;
    }
}

