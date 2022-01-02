/*  https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/

Print Anagrams Together 

Given an array of strings, return all groups of strings that are anagrams. 
The groups must be created in order of their appearance in the original array. 
Look at the sample case for clarification.
  
N = 5
words[] = {act,god,cat,dog,tac} */

class Solution {
  
   static HashSet<ArrayList<Character>> h = new HashSet<ArrayList<Character>>();
	 static HashMap<Integer, ArrayList<String>> h1 = new HashMap<Integer, ArrayList<String>>();
  
    public  int hashCode(String a) {
      ArrayList<Character> x = new ArrayList<Character>();
      for(int i = 0; i < a.length(); i++) {
        x.add(a.charAt(i));
      }
      Collections.sort(x);
      Iterator itr = h.iterator();
      while(itr.hasNext()) {
        ArrayList<Character> y = (ArrayList<Character>)itr.next();
        if(x.equals(y)) {
          //System.out.println(x.hashCode()+" "+y.hashCode());
          return x.hashCode();
        }
      }
      h.add(x);
      return x.hashCode();
    }
  
    //This function is to be called from main function
    public List<List<String>> Anagrams(String[] arr) {
        h.clear();
        h1.clear();
        for(int i = 0; i < arr.length; i++) {
    		int z = this.hashCode(arr[i]);
    		if(h1.containsKey(z)) {
    			ArrayList<String> t = h1.get(z);
    			t.add(arr[i]);
    			h1.put(z, t);
    		} else {
    			ArrayList<String> t = new ArrayList<String>();
    			t.add(arr[i]);
    			h1.put(z, t);
    		}
    	}
    	List<List<String>> result = new ArrayList<>();
    	for(Map.Entry<Integer, ArrayList<String>> m : h1.entrySet()) {
    	    ArrayList<String> t = m.getValue();
    	    result.add(t);
    	}
    	return result;
    }
}
