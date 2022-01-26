/*
https://practice.geeksforgeeks.org/problems/maximum-height-tree4803/1/?page=2&company[]=Walmart&query=page2company[]Walmart

Given N dots that form a triangle such that ith line contains i number of dots.

    .
   . .
  . . .
 . . . .
Find the minimum hieght H of the triangle that can be formed using these N dots.

Input: N = 10
Output: 4
Explaination: With 10 dots we can complete 
total four lines. The layers will have 1, 
2, 3 and 4 dots respectively.
*/


class Solution{
    static int height(int N){
        int s = 1;
        int i = 1;
        if(N == 1 || N == 2) return 1;
        while(s <= N) {
            i++;
            s = ((i+1)*i)/2;
            
        }
        return i-1;
    }
}
