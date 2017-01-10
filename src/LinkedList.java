class Node{
	Node next;
	int data;
	
	public Node (int d){
		data = d;
		Node next = null;
	}
}


public class LinkedList {
	private Node head;
	
	public LinkedList()
	{
		head = null;
	}
	
	// for testing 
	public static void main(String[] arg)
	{
		LinkedList list = new LinkedList();
		list.insert(3);
		list.insert(2);
		list.insert(4);
		list.insert(1);
		list.insert(5);
		System.out.println(list);
		System.out.println(list.indexOf(3));
		System.out.println(list.get(2));
		//list.removeAll(3);
		//list.removeAll(2);
		System.out.println(list);
		System.out.println(list.kthElement(2));
	}
	
	
	public int size()
	{
		Node cur = head;
		int count = 0;
		
		while (cur != null)
		{	
			cur = cur.next;
			count++;
		}
		return count;
	}
	

	// returns the int at a give index
	public int get(int index)
	{
		int data;
		Node cur = head;
		
		for(int i = 0; i < index; i++ )
		{
			if (cur.next != null)
			{
				cur = cur.next; 
			}
			else 
			{
				return -1;
			}
		}
		return cur.data;
	}
	
	//insert at the end
	public void appendFront (int data)
	{
		Node newNode = new Node(data);
		newNode.next = head.next;
		head.next = newNode;
		
	}
	
	public void appendEnd (int data)
	{
		Node cur = head;
		while(head.next != null)
		{
			cur = cur.next;
		}
		
		Node newNode = new Node(data);
		newNode.next = cur.next;
		cur.next = newNode;
	}
	
	// insert in a sorted order
	public void insert(int data)
	{
		//create new node
		Node newNode = new Node(data);
		
		// 1. empty or lowest value: insert at head
		if (head == null || newNode.data <= head.data)
		{
			newNode.next = head;
			head = newNode;
			return;
		}
		// 2. insert at the middle or end
		Node cur = head;
		while(cur.next != null && cur.next.data < data)
		{
			cur = cur.next;
		}
		newNode.next = cur.next;
		cur.next = newNode;
	}
	
	public void removeAll(int target)
	{
		
		//empty
		if (head == null) return;
		
		//1. remove from the head 
		while (head == null && head.data == target)
		{
			head = head.next;
		}
		if (head == null) return;
		
		
		for(Node cur = head; cur.next != null; cur = cur.next)
		{
			while(cur.next != null && cur.next.data == target)
			{
				cur.next = cur.next.next;
				cur.next.next = null; 
			}
		}
	}
	
	public int indexOf(int target)
	{
		//empty
		if (head == null) return -1;
	
		Node cur = head;
		int index = 0;
		
		while(cur != null)
		{
			if (cur.data == target)
			{
				return index; 
			}
			
			cur = cur.next;
			index++;
		}
		return -1;
		
	}
	
	//public LinkedList merge(LinkedList list2)
	//{
		
	//}
	
	private Node nodeAt(int index)
	{
		
		if (head == null) return null;
		if (index == 0) return head;
		
		Node cur = head.next;
		int count = 1;

		while (count < index)
		{
			cur = cur.next;
			count++;
		}
		
		return cur;
	}
	
	public String toString()
	{
		Node cur = head;
		
		if (cur == null) return "[]";
		StringBuffer str = new StringBuffer();
		str.append('[');
		
		
		str.append(cur.data);
		cur = cur.next;
		
		while(cur != null)
		{
			str.append(", ");
			str.append(cur.data);
			cur = cur.next;
		}
		str.append(']');
		
		return str.toString();
		
	}
	
	// Q1 write code to remove any duplicates from an unsorted linked list
	public void removeDup()
	{
		//1. sort the linkedlist 
		
		//2. delete the dups
		
		Node cur = head;
		while (cur != null)
		{
			while (cur.data == cur.next.data)
			{
				cur.next = cur.next.next;
				cur.next = null;
			}
			cur = cur.next;
		}
	}
	
	//Q2 implement an algorithm to find the kth to the last element of a singly linked list
	public int kthElement(int n)
	{
		Node firstPt = head;
		Node secondPt = head;
		
		for(int i = 0; i < n; i ++)
		{
			// list shorter than n
			if (firstPt == null) return -1;
			firstPt = firstPt.next;
		}
		
		while(firstPt != null)
		{
			firstPt = firstPt.next;
			secondPt = secondPt.next;
		}
		return secondPt.data;
	}
	
	//Q3 implement an algorithm to delete an node in the middle of a single linkedlist, given access to only that node
	public void deleteMiddle(Node mid)
	{
		mid.data = mid.next.data;
		
		//delete next
		mid.next = mid.next.next;
		mid.next.next = null;
	}
	
	//Q4 write code to partition a linked list around a value x, such that all nodes less than x come greater all does greater or eaual to x
	public Node patition(int x)
	{
		Node lesser = null;
		Node greater = null;
		
		while (head != null)
		{
			if (head.data < x)
			{
				Node temp = head;
				head = temp.next;
				temp = lesser;
				lesser = temp;
				
			}
			else
			{
				Node temp = head;
				head = temp.next;
				temp = greater;
				greater = temp;
				
			}	
		}
		Node cur = lesser;
		
		while(cur.next != null)
		{
			cur = cur.next;
		}
		cur.next = greater;
		return lesser;
	}
	
	// Q5 you have two number represented by a linked list, where each node contains a single digit. The digits are stored in revers order. such that the 1;s
	// digit is at the head of the list, write a function that adds the two number and returns the sume as a linked list
	
	
}
