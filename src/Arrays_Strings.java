
public class Arrays_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test1 = "";
		String test2 = "abcd";
		String test3 = "abcda";
		String test4 = "bb";

				
	//Question 1.1a: implement an algorithms to determine if a string
		// has all unique characters, what if you can not use data structures
		
		/*System.out.println(isUnique(test1));
		System.out.println(isUnique(test2));
		System.out.println(isUnique(test3));
		System.out.println(isUnique(test4));*/
		
	// Question 1.1b: what if you can not use data structures
		
	// Question 1.2: implement a function void reverse(char* str) in C or C++ 
		// which reverse a null terminated string
	
	// Question 1.3 Given two strings, write a method to decide if one is a 
		// of the other 
		
		String test5 = "bcda";
		String test6 = "abcd";
		String test7 = "abcda";
		String test8 = "bb";
		
		/*System.out.println(isPermutation(test2, test5)); //true
		System.out.println(isPermutation(test6, test7)); //false
		System.out.println(isPermutation(test8, test4)); //true
		*/
		
	// Question 1.4 write a method to replace all spaces in a string with %20. 
		// you may assume that the string has sufficient space at the end of the 
		// string to hold the additional characters, and that you are given the true
		// length of the string 
		
		String test9 = "Mr John Smith    ";
		
		//System.out.println(replaceSpace(test9, 13));
		
	// Question 1.5 implement a method to perform basic string compression using
		// of repeated characters. for example the string aabccccaa would become
		// a2b1c5a3. if the compressed string would become smaller than the orginal string,
		// your method should return the orginal string, you can assume the string has only
		// upper and lower case letters(a-z)
		
		String test10 = "aabcccccaaa"; // a2b1c5a3
		String test11 = "abc";
		String test12 = "";
		
		
		System.out.println(compress(test10));
		System.out.println(compress(test11));
		System.out.println(compress(test12));
		
	// Question 1.6 Given an image representation by an NxN matrix, where each
		// pixel in the image is 4 bytes, write a method to rotate the image
		// by 90 degrees. Can you do this in place
		
	// Question 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its 
		// entire row and column are set to 0 
		
		
	// Question 1.8 Assume you have a method isSupstring which checks if one word is a 
		//.args.
		
		
	}
	// Q1---------------------------------------
	static public boolean isUnique(String word)
	{
		boolean [] tempArr = new boolean[128]; 
		for(int i = 0; i < word.length(); i++)
		{			
			if (tempArr[word.charAt(i)] == false)
			{
				tempArr[word.charAt(i)] = true;
			}
			else return false;
		}
		return true;
	}
	
	static public boolean isUnique2(String word)
	{
		
		return true;
	}
	// Q2 -------------------------------------------
	
	static public boolean isPermutation(String s1, String s2)
	{
		if (s1.length() != s2.length()) return false;
		
		int [] tempArr1 = new int[128];
		for(int i = 0 ; i < s1.length(); i++)
		{
			tempArr1[s1.charAt(i)] = tempArr1[s1.charAt(i)]++ ;
		}
		
		int [] tempArr2 = new int[128];
		for(int i = 0 ; i < s2.length(); i++)
		{
			tempArr2[s2.charAt(i)] = tempArr1[s2.charAt(i)]++ ;
		}
		
		for (int i = 0; i < 128; i++)
		{
			if(tempArr1[i] != tempArr2[i]) return false;
		}
		
		return true;
	}
	
	// Q4 ----------------------------------------------
	static public String replaceSpace(String s, int trueLength)
	{
		char[] charArray = s.toCharArray();
		
		int sPos = trueLength-1;
		int arrPos = charArray.length-1; 
		
		while(sPos >= 0 && arrPos >= 0)
		{
			if(charArray[sPos] != ' ')
			{
				charArray[arrPos] = charArray[sPos];
				arrPos--;
				sPos--;
			}
			else
			{
				charArray[arrPos--] = '0';
				charArray[arrPos--] = '2';
				charArray[arrPos--] = '%';
				sPos--;
			}
		}
		return new String(charArray);
	}
	
	// Q5 -----------------------------------------------
	static public String compress(String s)
	{
		//1.
		if (s == "") return s;
		
		StringBuffer comp = new StringBuffer();
		int count = 1;
		
		//2.
		for (int i = 1; i < s.length(); i++ )
		{
			//count++;
			if(s.charAt(i) != s.charAt(i-1))
			{
				comp.append(s.charAt(i-1));
				comp.append(count);
				count = 0;
			}
			count++;
			
		}
		comp.append(s.charAt(s.length()-1));
		comp.append(count);
		
		//3.
		if (comp.length() < s.length()) return comp.toString();
		else return s;
	}
	
	// Q7 ---------------------------------------------------
	
	//static public void (int[][] D2)
	//{
	//	for(int i = o)
	//}
	
	// Q8 ---------------------------------------------------	
		// 	

}
