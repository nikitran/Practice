

public class stack {
	private Node top;
	private int Size;
	
	public stack()
	{
		top = null;
		Size = 0; 
	}
	
	public static void main(String[] arg)
	{
		stack newStack = new stack();
		newStack.push(1);
		newStack.push(3);
		newStack.push(2);
		newStack.push(6);
		newStack.push(5);
		newStack.push(4);

		
		System.out.println(newStack);
		newStack.sortStack();
		System.out.println(newStack);
				
	}
	
	public void push(int newInt)
	{
		//insert at the head:
		Node newNode = new Node(newInt);
		newNode.next = top; 
		top = newNode;
		Size++;
	}
	
	public int pop()
	{
		if (top == null) return -1;
		
		//remove from head
		int value = top.data;
		top = top.next;
		Size--;
		return value;
	}
	
	public int peek()
	{
		if (top == null) return -1;
		
		return top.data;
	}
	
	public int size()
	{
		return Size;
	}
	
	public String toString()
	{
		Node cur = top;
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
	
	public void sortStack()
	{
		stack temp = new stack();
		int min = this.pop();
		boolean curMin = true;
		temp.push(min);
		
		while(this.top != null)
		{	
			if (min < this.peek() && curMin)
			{
				temp.push(min);
				curMin = false;
			}
			while (this.peek() >= temp.peek())
			{
				if (min < this.peek() && curMin)
				{
					temp.push(min);
					curMin = false;
				}
				temp.push(this.pop());
				
			}
			if (this.top == null) break;
			min = this.pop();
			curMin = true;
			
			while (temp.size() > 0)
			{
				this.push(temp.pop());
			}
			
			//temp.push(min);		
		}
		
		while(temp.size() > 0)
		{
			this.push(temp.pop());
		}
	}
	

}
