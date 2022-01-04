/*
https://practice.geeksforgeeks.org/problems/find-the-position-of-m-th-item1723/1/#

M items are to be delivered in a circle of size N. Find the position where the M-th item will be delivered 
if we start from a given position K. 
Note that items are distributed at adjacent positions starting from K.

 

Example 1:

Input:
N = 5, M = 2, K = 1
Output:
2

*/

class Solution {
    static int findPosition(int N , int M , int K) {
        
        if(N == 1) {
            return 1;
        } 
        int temp = (M+K-1)%N;
        if(temp == 0) {
            return N;
        }
       return temp;
    }
}
