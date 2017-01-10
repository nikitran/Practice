
public class queue {
	private Node head;
	private Node tail;
	
	public queue()
	{
		head = null;
		tail = null;
	}
	
	/*public static void main(String[] arg)
	{
		queue Q = new queue();
		Q.enqueue(1);
		Q.enqueue(2);
		
		System.out.println(Q);
	}*/
	
	public void enqueue(int value)
	{
		Node newNode = new Node(value);
		
		//1. 1st node
		if (head == null && tail == null)
		{
			head = newNode; 
			tail = newNode;
		}
		else //2. insert at the tail 
		{
			tail.next = newNode;
			tail = tail.next;
		}
	}
	
	public int dequeue()
	{
		if (head == null) return -1;
		
		int value = head.data;
		head = head.next;
		if(head == null) tail = null;

		return value;
	}
	
	public String toString()
	{
		Node cur = head;
		StringBuffer str = new StringBuffer();
		str.append('[');
		if (cur == null) return "[]";
		
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
}
 