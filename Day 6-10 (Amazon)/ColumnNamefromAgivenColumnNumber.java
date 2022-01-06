/*
https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1/#

Given a positive integer, return its corresponding column title as appear in an Excel sheet.
Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB, … ZZ, AAA, AAB ….. etc. 
In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA” and so on.

Example 1:

Input:
N = 28
Output: AB
Explanation: 1 to 26 are A to Z.
Then, 27 is AA and 28 = AB.


*/

class Solution {
    String colName (long n) {
        
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            long t = n%26;
            if(t == 0) {
                t = 26;
            }
            sb.insert(0, (char)(t+64));
            n = n-t;
            n /=26;
            //System.out.println(n);
        }
        return sb.toString();
    }
}
