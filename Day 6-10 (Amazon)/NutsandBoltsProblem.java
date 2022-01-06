/*
https://practice.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1#

Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and bolts. 
Match nuts and bolts efficiently.

Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and 
bolt can only be compared with nut to see which one is bigger/smaller.
The elements should follow the following order ! # $ % & * @ ^ ~ .

Example 1:

Input: 
N = 5
nuts[] = {@, %, $, #, ^}
bolts[] = {%, @, #, $ ^}
Output: 
# $ % @ ^
# $ % @ ^

*/


class Solution {
    void matchPairs(char nuts[], char bolts[], int n) {
        TreeSet<Character> set1 = new TreeSet<Character>();
        TreeSet<Character> set2 = new TreeSet<Character>();
        for(int i = 0; i < nuts.length; i++) {
            set1.add(nuts[i]);
            set2.add(nuts[i]);
        }
        set1.retainAll(set2);
        int j = 0;
        for(Character i : set1) {
            nuts[j] = bolts[j] = i;
            j++;
        }
        return;
    }
}
