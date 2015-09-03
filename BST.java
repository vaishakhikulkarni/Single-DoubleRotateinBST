//Vaishakhi Kulkarni
//vpk140230

import java.util.Scanner;

public class BST<T extends Comparable<? super T>> {
	//Create node
	public class Node {
		public T data; 
		Node left; 
		Node right;

		public Node(T elem) {
			data = elem;
			left = null;
			right = null;
		}

		public Node(T elem, Node lt, Node rt) {
			data = elem;
			left = lt;
			right = rt;
		}
	}

	public Node root;

	public BST() {
		root = null;
	}
	//find element
	public void find(T elem) {
		Boolean found = find(root, elem);
		if(found)
			System.out.print("Element is present");
	}
	//helper function to find
	public Boolean find(Node temp, T x) {

		if (temp == null) {
			return false;
		}

		int cmp = temp.data.compareTo(x);

		if (cmp > 0) {
			return find(temp.left, x);
		}

		else if (cmp < 0) {
			return find(temp.right, x);
		}

		else {
			return true;
		}
	}
	//Check to perform single and double rotatio
	public void check(T elem) {
		if(root.data==elem)//if root no ction required
			System.out.println("No action required");
		else if(root.right.data.compareTo(elem)==0 || root.left.data.compareTo(elem)==0)//If child of root perform single rotation
		{
			singleRotation(elem);
			
		}
		else	//perform double rotation
			check(root,elem);
	}
	
	public Boolean check(Node temp, T x) {

		if (temp == null) {
			System.out.println("Element not present");
		}

		int cmp = temp.data.compareTo(x);

		if (cmp > 0) {
			return find(temp.left, x);
		}

		else if (cmp < 0) {
			return find(temp.right, x);
		}

		else {
			
			singleRotation(x);
			
			return true;
		}
	}
	//Insert operation
	public boolean insert(T elem) {
		return insert(root, elem);
	}

	public boolean insert(Node temp, T x) {
		if (temp == null) {
			root = new Node(x, null, null);
			return true;
		}

		int cmp = temp.data.compareTo(x);

		if (cmp > 0) {
			if (temp.left == null) {
				temp.left = new Node(x, null, null);
				return true;
			}
			return insert(temp.left, x);
		}

		else if (cmp < 0) {
			if (temp.right == null) {
				temp.right = new Node(x, null, null);
				return true;
			}
			return insert(temp.right, x);
		} else {
			return false;
		}
	}
	//iNORDER TRAAVERSAL TO CHECK
	public void inorder() {
		inorder(root);
	}

	public void inorder(Node temp) {
		if (temp != null) {
			
			inorder(temp.left);
			System.out.println(temp.data);
			inorder(temp.right);
		}
	}
	//Perfrom single rotation
	public void singleRotation(T x)
	{
		Node finals = singlerotation(root,x);
		root = finals;
		inorder(root);
	}
	.//Perform single rotation at left and right of root
	public Node singlerotation(Node roots,T x)
	{
	
		if(roots.left==null && roots.right==null)
			return roots;
		else if(roots.right.data==x)
		{
			Node roottemp = roots;
			roots = roots.right;
			Node childleft = roots.left;
			roottemp.right = childleft;
			roots.left = roottemp;
			return roots;
		}
		else if(roots.left.data==x)
		{
			Node roottemp = roots;
			roots = roots.left;
			Node childright = roots.right;
			roottemp.left = childright;
			roots.right = roottemp;
			return roots;
		}
		else
			return roots;
		
	}
	
	public static void main(String[] args) {

		System.out.println("BST insert");
		System.out.println("Enter no of elements into the BST tree");

		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		System.out.println("Enter the elements");
		System.out.println(" ");
		BST<Integer> x = new BST<Integer>();
		int i = 0;
		while (i != size) {
			x.insert(scan.nextInt());
			i++;
		}
		x.inorder();
		System.out.println("Find element to rotate");
		Integer value = scan.nextInt();
		x.find(value);
		x.check(value);
		scan.close();

	}
}
