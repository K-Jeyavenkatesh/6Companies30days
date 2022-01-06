/*
https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1/

Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.

Example:
Input:
2
8
2 1
9 1 3 5 9 4 10 1
6
6 1
1 2 3 4 5 6

Output: 
9 1 5 9 10 1
1 2 3 4 5 6

Explanation:
Testcase 1: Deleting one node after skipping the M nodes each time, we have list as 9-> 1-> 5-> 9-> 10-> 1.

*/
class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        if(head == null) {
            return;
        }
        int length = 0;
        Node ptr = head;
        while(ptr != null) {
            length++;
            ptr = ptr.next;
        }
        if(M >= length) {
            return;
        }
        if(M+N >= length) {
            ptr = head;
            for(int i = 1; i < M; i++) {
                ptr = ptr.next;
            }
            ptr.next = null;
            return;
        }
        ptr = head;
        for(int i = 1; i < M; i++) {
            ptr = ptr.next;
        }
        Node temp = ptr;
        for(int i = 0; i < N; i++) {
            temp = temp.next;
        }
        ptr.next = temp.next;
        ptr = ptr.next;
        linkdelete(ptr, M, N);
    }
}
