/* Possible Bipartition
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
 */
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] partition = new int[N];
        Arrays.fill(partition, -1);
        ArrayList<Integer>[] adj = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] arr: dislikes) {
            adj[arr[0]-1].add(arr[1] - 1);
            adj[arr[1]-1].add(arr[0] - 1);
        }
        for(int i = 0; i < N; i++) {
            if(partition[i] == -1 && !DFS(adj, partition, i, 0))
                return false;
        }
        return true;
    }
    private boolean DFS(ArrayList<Integer>[] adj, int[] partition, int v, int group) {
        if(partition[v] == -1)
            partition[v] = group;
        else
            return partition[v] == group;
        for(int x: adj[v]) {
            if(!DFS(adj, partition, x, 1 - group))
                return false;
        }
        return true;
    }
}

