/* Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters. 
 */

class Solution {
    public String frequencySort(String s) {
        int[] hash = new int[128];
        for(char c: s.toCharArray()) {
            hash[c]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 128; i++) {
            if(hash[i] > 0)
                list.add(hash[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        Integer[] arr = list.toArray(new Integer[list.size()]);
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            int len = arr[i];
            for(int j = 0; j < 128; j++) {
                if(hash[j]==len) {
                    while(hash[j] > 0) {
                        str.append((char)j);
                        hash[j]--;
                    }
                    j=128; //break;
                }
            }
        }
        return str.toString();
    }
}

