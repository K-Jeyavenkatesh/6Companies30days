/*
https://practice.geeksforgeeks.org/problems/phone-directory4628/1/#

Given a list of contacts contact[] of length n where each contact is a string which exist in a phone directory and a query string s. 
The task is to implement a search query for the phone directory. Run a search query for each prefix p of the query string s (i.e. from  index 1 to |s|) 
that prints all the distinct contacts which have the same prefix as p in lexicographical increasing order. Please refer the explanation part for better understanding.
Note: If there is no match between query and contacts, print "0".

Example 1:

Input: 
n = 3
contact[] = {"geeikistest", "geeksforgeeks", "geeksfortest"}
s = "geeips"
Output:
geeikistest geeksforgeeks geeksfortest
geeikistest geeksforgeeks geeksfortest
geeikistest geeksforgeeks geeksfortest
geeikistest
0
0

*/


//This is Brute Force But Best Way is to approach with Trie
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s){
        
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = true, ptr = false;
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            ArrayList<String> temp = new ArrayList<String>();
            if(flag) {
                flag = false;
                for(int j = 0; j < n; j++) {
                    if((s.charAt(0)+"").equals((contact[j].charAt(0)+""))) {
                        temp.add(contact[j]);
                    }
                }
                if(temp.size() == 0) {
                    temp.add("0");
                    ptr = true;
                }
            } else if(ptr) {
                temp.add("0");
            } else {
                for(int j = 0; j < res.get(i-1).size(); j++) {
                    
                    if(res.get(i-1).get(j).length() >= i+1 && s.substring(0, i+1).equals(res.get(i-1).get(j).substring(0, i+1))) {
                        //System.out.println(s.substring(0, i+1)+" "+res.get(i-1).get(j).substring(0, i+1)+" "+i);
                        temp.add(res.get(i-1).get(j));
                    }
                }
                if(temp.size() == 0) {
                    temp.add("0");
                    ptr = true;
                }
            }
            HashSet<String> h = new HashSet<String>(temp);
            temp = new ArrayList<String>(h);
            Collections.sort(temp);
            res.add(temp);
        }
        return res;
    }
}
