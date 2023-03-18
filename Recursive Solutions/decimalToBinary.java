//Q: How to convert a number from Decimal to Binary using recursion?
//To convert a number to binary you have to recursively divide it by 2 and return number % 2:
class decimalToBinary{
	public static void main(String[] args){
		System.out.println(decimalToBinary(10));
		System.out.println(decimalToBinary(2));	
		System.out.println(decimalToBinary(256));
		//this will be out of int's byte range.
		System.out.println(decimalToBinary(5050));
	}
	public static int decimalToBinary(int n){
		if(n==0)
			return 0;		
		
		else
			return (n%2+10*decimalToBinary(n/2));
	}
}