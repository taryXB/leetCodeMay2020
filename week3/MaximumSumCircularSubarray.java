/* Maximum Sum Circular Subarray
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
*/
class Solution {
    private int kadanes(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum = Math.max(A[i], sum + A[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSubarraySumCircular(int[] A) {
        int maxSub = kadanes(A);

        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            A[i] = -A[i];
        }

        sum = sum + kadanes(A);

        if(sum>0)
            return Math.max(sum, maxSub);
        return maxSub;
    }
}

