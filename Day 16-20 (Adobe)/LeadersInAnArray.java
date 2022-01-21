/*

https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/

Given an array A of positive integers. Your task is to find the leaders in the array.
An element of array is leader if it is greater than or equal to all the elements to its right side. 
The rightmost element is always a leader. 

Example 1:

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17 
as it is greater than all the elements
to its right.  Similarly, the next 
leader is 5. The right most element 
is always a leader so it is also 
included.
*/


class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        
		int max = arr[n-1];
		int[] a = new int[n];
		int j = 0;
		ArrayList<Integer> leader = new ArrayList<Integer>();
		for(int i = n-2; i >=0; i--){
			if(arr[i] >= max){
				a[j++] = max;
				max = arr[i];
			}
			
		}
		a[j] = max;
		for(int i = j; i >=0; i--){
		    leader.add(a[i]);
		}
		return leader;
    }
}
