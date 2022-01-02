/*
https://practice.geeksforgeeks.org/problems/run-length-encoding/1/

Run Length Encoding 

Given a string, Your task is to  complete the function encode that returns the run length 
encoded string for the given string.
Example: if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
You are required to complete the function encode that takes only one argument the string which is to be encoded and returns the encoded string.

Input:
str = aaaabbbccc
Output: a4b3c3

*/

class Solution {
  
	String encode(String str) {
	    
	    int n = str.length();
	    char temp = str.charAt(0);
	    int count = 1;
       
        StringBuilder sb = new StringBuilder();
    
        for(int i = 1; i < n; i++) {
            if(temp != str.charAt(i)) {
                sb.append(temp);
                sb.append(count);
                temp = str.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(temp);
        sb.append(count);
        return sb.toString();
	}
	
 }
