
public class BSTree {
	private Node root;
	
	public Node root() {
		return root;
	}
	
	public String toTheString(Node n){
		return n.data+"("+n.counter+")";
	}
	
	public BSTree(){
		root = null;
	}
	
	class Node{
		private String data;
		private Node left;
		private Node right;
		private int counter;
		
		public Node(String s){
			data = s;
			left = null;
			right = null;
			counter = 1;
		}
		
		public String toString(){
			return data;
		}
	}
	

	public void insert(String s){
		insert(s, root);	
	}
	private void insert(String s, Node n){
		Node curr = new Node(s);
		if (n == null){
			root = curr;
		}
		else if ((n.left==null)&&(s.compareTo(n.toString())<0)){
			n.left = curr;
		}
		else if (s.compareTo(n.toString())==0){
			n.counter++;
		}
		else if ((n.right==null)&&(s.compareTo(n.toString())>0)){
			n.right = curr;
		}
		else if (s.compareTo(n.toString())<0){
			insert(s, n.left);
		}
		else if (s.compareTo(n.toString())>0){
			insert(s, n.right);
		}
	}

	
	public boolean find(String s) {
		return find(s, root);
	}
	private boolean find(String s, Node n){
		if(n == null){
			return false;
		}
		else if(s.compareTo(n.toString())==0){
			return true;
		}
		else if(s.compareTo(n.toString())<0){
			return find(s, n.left);
		}
		else if(s.compareTo(n.toString())>0){
			return find(s, n.right);
		}
		return false;
	}
	
	public void delete (String s){
		delete(s, root);
	}
	private Node delete(String s, Node n){
	    if (n == null){ 
	    	return null;
	    }
	    if (n.data.compareTo(s) == 0) {
	    	if (n.counter>1){
	    		n.counter--;
	    		return n;
	    	}else{
		    	if (n.left == null){
		    		root = n.right;
		    		return n.right;
		    	}
		    	else if (n.right == null){
		    		root = n.left;
		    		return n.left;
		    	}
		    	else{
		    		if (n.right.left == null) {
		            n.data = n.right.data;
		            n.right = n.right.right;
		            return n;
		    		}else{         
		    			n.data = rightSmallest(n.right);
		    			return n;
		            }
		         }
	    	}
	    }else if (s.compareTo(n.data) < 0){
	    	  n.left = delete(s, n.left);
	    	  return n;
	    }else{
	    	  n.right = delete(s, n.right);
	    	  return n;
	    }
	}  
	 
	private String rightSmallest(Node n) {
		if (n.left.left == null) {
			String smallest = n.left.data;
	        n.left = n.left.right;
	        return smallest;
	    }else{
	    	return rightSmallest(n.left);
	    }
	}

	
	public String toStringInOrder(){
		return leftMidRight(root);
	}
	
	private String leftMidRight(Node n){
		if (n!=null){
			return leftMidRight(n.left).trim()+" "+n.data+" "+leftMidRight(n.right).trim();
		}
		return "";
	}
	
	
	public String toStringPreOrder(){
		return midLeftRight(root).trim();
	}
	private String midLeftRight(Node n){
		if (n!=null){
			return n.data+" "+midLeftRight(n.left)+midLeftRight(n.right);
		}
		return "";
	}

	
	public void print(Node n){
		if (n!=null){
			print(n.left);
			System.out.print(n+""+n.counter+" ");
			print(n.right);
		}
	}
}
