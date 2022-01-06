/*
https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1

Serialization is to store a tree in an array so that it can be later restored and 
Deserialization is reading tree back from the array. Now your task is to complete the function serialize which stores 
the tree into an array A[ ] and deSerialize which deserializes the array to the tree and returns it.
Note: The structure of the tree must be maintained. Multiple nodes can have the same data.

Example 1:

Input:
      1
    /   \
   2     3
Output: 2 1 3

*/


class Tree 
{
    
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    if(root == null) {
	        return;
	    }
	    Queue<Node> q = new LinkedList<Node>();
	    q.add(root);
	    while(!q.isEmpty()) {
	        root = q.poll();
	        if(root == null) {
	            A.add(-1);
	            continue;
	        }
	        A.add(root.data);
	        q.add(root.left);
	        q.add(root.right);
	    }
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //System.out.println(A);
        int n = A.size();
        Node root = null;
        if(A.isEmpty()) {
            return null;
        }
        int i = 0;
        root = new Node(A.get(i));
        i++;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
            Node temp = q.poll();
            if(i < n && A.get(i) != -1) {
                temp.left = new Node(A.get(i));
                q.add(temp.left);
            }
            i++;
            if(i < n && A.get(i) != -1) {
                temp.right= new Node(A.get(i));
                q.add(temp.right);
            }
            i++;
        }
        return root;
    }
}
