//3.5 - implement a MyQueue class which implements a queue using 2 stack

public class myQueue {
	private boolean pushable;
	private stack pushStack;
	private stack popStack;
	
	public myQueue()
	{
		pushable = true;
		pushStack = new stack();
		popStack = new stack();
	}
	
	public static void main(String[] arg)
	{
		myQueue myQ = new myQueue();
		myQ.enqueue(1);
		myQ.enqueue(2);
		myQ.enqueue(3);
		myQ.enqueue(4);
		myQ.enqueue(5);
		System.out.println(myQ);
		
		myQ.dequeue();
		System.out.println(myQ);
		myQ.dequeue();
		System.out.println(myQ);
		myQ.enqueue(1);
		myQ.enqueue(2);
		myQ.enqueue(3);
		System.out.println(myQ);
		
		
	}
	
	public void enqueue(int value)
	{
		if (pushable)
		{
			pushStack.push(value);
		}
		else
		{
			switchStack();
			pushStack.push(value);
		}
	
	}
	
	public int dequeue()
	{
		if (!pushable){
			return popStack.pop();
		}
		else 
		{
			switchStack();
			return popStack.pop();
		}
	}
	
	private void switchStack()
	{
		if (pushable)
		{
			while(pushStack.size() > 0)
			{
				popStack.push(pushStack.pop());
			}
			pushable = false;
		}
		else
		{
			while(popStack.size() > 0)
			{
				pushStack.push(popStack.pop());
			}	
			pushable = true;
		}
	}
	public String toString()
	{	
		if(pushable)
		{
			switchStack();
			return popStack.toString();
		}
		else return popStack.toString();
	}
}
