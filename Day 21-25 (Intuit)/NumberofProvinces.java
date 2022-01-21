/*

https://leetcode.com/problems/number-of-provinces/

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, 
and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and 
the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
Example 1:

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

*/

class Solution {
    public int findCircleNum(int[][] graph) {
        
        int n = graph.length;
        HashSet<Integer> hash = new HashSet<Integer>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(i);
            if(!hash.contains(i)) {
                hash.add(i);
                count++;
            }
            while(!queue.isEmpty()) {
                int temp = queue.poll();
                for(int j = 0; j < n; j++) {
                    if(graph[temp][j] == 1 && !hash.contains(j)) {
                        queue.add(j);
                        hash.add(j);
                    }
                }
            }
        }
        return count;
    }
}
