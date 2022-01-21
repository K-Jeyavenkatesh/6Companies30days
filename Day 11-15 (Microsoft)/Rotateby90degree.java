/*

https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1/

Given a square matrix[][] of size N x N. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space.

Example 1:

Input:
N = 3
matrix[][] = [[1 2 3],
              [4 5 6],
              [7 8 9]]
Output:
3 6 9 
2 5 8 
1 4 7

*/


class GFG
{
    static void rotate(int matrix[][]) 
    {
        int n=(matrix[0]).length;
        int x=0;
        int[][] arr=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                arr[x][j]=matrix[j][i];
            }
            x++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=arr[i][j];
            }
        }
    }
}
