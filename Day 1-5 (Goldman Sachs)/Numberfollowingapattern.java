/*

https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1#

Number following a pattern 

Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can't repeat.

Example 1:
Input:
D
Output:
21

Example 2:
Input:
IIDDD
Output:
126543
Explanation:
Above example is self- explanatory,
1 < 2 < 6 > 5 > 4 > 3
  I - I - D - D - D

*/


class Solution{
    static String printMinNumberForPattern(String s){

        boolean[] flag = new boolean[10];
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        flag[1] = flag[2] = true;
        if(s.charAt(0) == 'I') {
            stack.push(1);
            stack.push(2);
        } else {
            stack.push(2);
            stack.push(1);
        }
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == 'I') {
                int x = stack.peek()+1;
                while(flag[x]) {
                    x++;
                }
                flag[x] = true;
                stack.push(x);
            } else {
        
                int x = stack.peek();
                int y = x;
                if((x-1 > 0 && flag[x-1]) || x == 1) {
                    x = stack.pop();
                    while(!stack.isEmpty() && stack.peek() > x) {
                        x = stack.pop();
                    }
                    x++;
                    flag[x] = true;
                    while(x >= y) {
                        stack.push(x--);
                    }
                }
            }
           // System.out.println(stack);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
