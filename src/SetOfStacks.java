class SetOfStacks{
	private int maxPlates;
	private int maxStacks;
	private int curStack;
	private stack[] arrOfStacks;
	
	/*public static void main(String[] arg)
	{
		SetOfStacks newSet = new SetOfStacks(2,3);
		newSet.push(1);
		newSet.push(2);
		newSet.push(3);
		newSet.push(4);
		newSet.push(5);
		newSet.push(6);
		newSet.push(7);
		newSet.push(8);
		System.out.println(newSet);
		newSet.pop();
		System.out.println(newSet);
		newSet.pop();
		System.out.println(newSet);
		newSet.popAt(0);
		System.out.println(newSet);
		
	}*/
	
	public SetOfStacks(int maxPlates, int maxStacks)
	{
		curStack = 0;
		this.maxPlates = maxPlates;
		this.maxStacks = maxStacks;
		arrOfStacks = new stack[maxStacks];
		arrOfStacks[curStack] = new stack();
	}
	
	public int pop()
	{
		int popVal = arrOfStacks[curStack].pop();
		
		if (arrOfStacks[curStack].size() <= 0 && curStack != 0) 
		{
			curStack--;
		}
		
		return popVal;
	}
	
	public int popAt(int index)
	{
		if (index < maxStacks && index >= 0){
			
			int popVal = arrOfStacks[index].pop();
			
			if (index == curStack && arrOfStacks[curStack].size() <= 0 && curStack != 0) 
			{
				curStack--;
			}
			
			return popVal;
		}
		return -1;
	}
	
	public boolean push(int val)
	{
		if (this.isFull())
		{
			return false;
		}
		
		//not full
		arrOfStacks[curStack].push(val);
		if (arrOfStacks[curStack].size() >= maxPlates && curStack + 1 < maxStacks )
		{
			curStack++;
			arrOfStacks[curStack] = new stack();
		}
		return true;
		
		//check if full 
	}
	
	private boolean isFull()
	{
		return (curStack + 1 >= maxStacks && arrOfStacks[curStack].size() >= maxPlates);
	}
	
	public String toString()
	{
		StringBuffer strBuf = new StringBuffer();
		for(int i = curStack; i >= 0 ; i--)
		{
			strBuf.append(arrOfStacks[i]);
		}
		return strBuf.toString();
	}
	
}


