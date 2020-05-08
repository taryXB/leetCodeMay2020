/* Check If It Is a Straight Line

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Constraints:

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.

Example 1: 
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        float m = coordinates.length;
        if(m == 2) return true;
        float y2 = coordinates[1][1];
        float y1 = coordinates[0][1];
        float x2 = coordinates[1][0];
        float x1 = coordinates[0][0];
        float slope = (y2-y1)/(x2-x1);
        for(int i = 2; i < m; i++){
            y2 = coordinates[i][1];
            x2 = coordinates[i][0];
            if(slope != (y2-y1)/(x2-x1))
                return false;
        }
        return true;
    }
}
