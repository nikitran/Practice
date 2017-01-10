class treeNode
{
	//Object item; 
	int data;
	treeNode left;
	treeNode right;
	
	public treeNode(int val)
	{
		data = val;
		left = null;
		right = null;
	}
}

public class BST {
	private treeNode Root;
	
	public BST()
	{
		Root = null;
	}
	
	public static void main(String[] arg)
	{
		BST tree = new BST();
		tree.insert(2);
		tree.insert(1);
		tree.insert(5);
		tree.display();
		System.out.println(tree.countLeaves());
		System.out.println(tree.countAllNodes());
		tree.insert(6);
		tree.insert(3);
		tree.insert(7);
		tree.insert(8);
		System.out.println(tree.minDepth());
		System.out.println(tree.height());
		System.out.println(tree.isBalance());
		//System.out.println(tree.countLevels());
		//tree.deleteMin();
		//tree.deleteMin();
		
		int[] values = {1,2,3,4,5,6};
		BST tree2 = new BST();
		//tree2.arrInsert(values, 0, values.length-1);
		tree2.display();
	}
	public boolean find(treeNode root, int key)
	{
		if (root == null) return false; // not found
		else if(root.data == key)
			return true;
		else if (root.data < key)
			return find(root.right, key);
		else 
			return find(root.left, key);
	}
	
	public int retrieve(treeNode root, int key)
	{
		if (root == null) return -1; // not found
		else if(root.data == key)
			return root.data;
		else if (root.data < key)
			return retrieve(root.right, key);
		else 
			return retrieve(root.left, key);
	}
	public int retrieve(int key)
	{
		return retrieve(Root, key);
	}
	
	//insert
	private void insert(int data)
	{
		treeNode newNode = new treeNode(data);
		
		//1. empty tree
		if (Root == null) 
		{
			Root = newNode;
			return;
		}
		//2. 
		treeNode cur = Root;
		
		while(true)
		{
			if (data < cur.data)
			{
				if (cur.left == null) 
				{
					cur.left = newNode;
					return;
				}
				cur = cur.left;
			
			}
			else 
			{	
				
				if (cur.right == null) 
				{
					cur.right = newNode;
					return;
				}
				cur = cur.right;
			}
		}
	}
	
	// display - in order
	public void display(treeNode root)
	{
		if(root != null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	public void display()
	{
		display(Root);
	}

	private int countLeaves(treeNode root)
	{
		if (root == null) return 0;
		if (root.right == null && root.left == null) return 1;
		else return (countLeaves(root.left) + countLeaves(root.right));
		
	}
	// leaves - no children 
	public int countLeaves()
	{
		return countLeaves(Root);
	}
	
	/*
	public boolean deleteMin()
	{
		if (Root == null) return false;
		if (Root.left == null)
		{
			//delete the node 
		}
		
		treeNode cur = Root;
		while(cur.left.left != null)
		{
			cur = cur.left;
		}
		cur.left = null;
		return true;
	}
	*/
	public int returnMin()
	{
		if (Root == null) return -1;
		if (Root.left == null)
		{
			return Root.data;
		}
		
		treeNode cur = Root;
		while(cur.left != null)
		{
			cur = cur.left;
		}
		return cur.data;
	}
	
	// 4.5 implement a function to check if a binary tree is a BST
	private boolean isBST(treeNode root)
	{
		if (root == null) 
			return true;
		if (root.left != null && root.left.data < root.data) 
			return false;
		if (root.right != null && root.right.data >= root.data) 
			return false;
		if (!isBST(root.left) || !isBST(root.right)) 
			return false;
		else 
			return true;
	}
	public boolean isBST(BST tree)
	{
		return isBST(tree.Root);
	}
	
	// count all the nodes in the tree
	private int countAllNodes(treeNode root)
	{
		if (root == null) return 0;
		return 1 + countAllNodes(root.left) + countAllNodes(root.right);
	}
	public int countAllNodes()
	{
		return countAllNodes(Root);
	}
	
	// find the hieght of the tree
	public int height(treeNode root)
	{
		if (root == null) return -1; // height of a empty tree = -1
									 // height of 1 node tree = 0
		int leftBranch = 1 + height(root.left);
		int rightBranch = 1 + height(root.right);
		
		if (leftBranch > rightBranch) return leftBranch;
		else return rightBranch;
	}
	public int height()
	{
		return height(Root);
	}
	
	// finds the shortest hight of the tree
	public int minDepth(treeNode root)
	{
		if (root == null) return -1; // height of a empty tree = -1
									 // height of 1 node tree = 0
		int leftBranch = 1 + height(root.left);
		int rightBranch = 1 + height(root.right);
		
		if (leftBranch > rightBranch) return rightBranch;
		else return leftBranch;
	}
	public int minDepth()
	{
		return minDepth(Root);
	}
	
	// 4.1 implement a function to check if a binary tree is balanced. balanced
	public boolean isBalance(treeNode root)
	{
		if (root == null) return true; 
		
		int minDepth = minDepth(root);
		int maxHieght = height(root);
		
		return ( maxHieght - minDepth <= 1);
	}
	public boolean isBalance()
	{
		return isBalance(Root);
	}
	
	// count all the Nodes at a given level
	public int countNodeAtLevel(treeNode root, int level)
	{
		if (root == null) return 0;
		if (level == 0) return 1;
		else 
			return (countNodeAtLevel(root.left, level - 1) + countNodeAtLevel(root.right, level-1));	
	}
	public int countNodeAtLevel(int level)
	{
		return countNodeAtLevel(Root, level);
	}
	
	// find the depth of a given node
	public int depth(treeNode root, int key)
	{
		if (root == null) return -1; 
		if (root.data == key) return 0;
		
		int tryBranch = depth(root.left, key);
		if (tryBranch == -1)
			tryBranch = depth (root.right, key);
		if (tryBranch == -1) return -1;
		
		else return 1 + tryBranch;
	}
	// index = [0 1 2 3 4 5 6]
	// value = [1 2 3 4 5 6 7] 
	// [1 2 3] [5 6 7]
	// [1] [3] [6] [7]
	// value = [1 2 3 4 5 6] 
	// [1 2 3] [5 6]
	// [1] [3] [6] [7]
	
	//- 7/2 = 3
	//- 

	// 4.3 given a sorted array, create the shortest BST 
	public void arrInsert(int[] values, int min, int max)
	{
		if(values == null) return;
		if( min == max)
		{
			this.insert(values[min]);
		}
		else
		{
			int midIndex = min + (max-min)/2;
			{
				this.insert(values[midIndex]);
				arrInsert(values, min, midIndex -1);
				arrInsert(values, midIndex+1, max);
			}	
		}
	}
	
	// 4.4 create create a linked list of all the nodes of each depth level
	
	// 4.7 Design an algorithm and write code to find the first common sncestor of two nodes
	/*
	public int findAncestors(treeNode root, int first, int second)
	{
		if (root == null) return -1; 
		if (find(root.left, first) && find(root.right, second) || find(root.left, first) && find(root.right, second))
		{
			return root.data;
		}
		else 
		{
			findAncestors(root.left, first, second);
			findAncestors(root.right, first, second);
			
		}
		return -1;

	}*/
}

