//Q: Write a recursive function which returns true if the string passed to it is a palindrome
class palindromeCheck {
    public static void main(String[] args) {
        System.out.println(isPalindrome("baran"));
        System.out.println(isPalindrome("123321"));
    }
    public  static boolean isPalindrome(String s)
    {   
        if(s.length() == 1 || s.length() == 0)
            return true;
        
        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1,s.length()-1));
        
        return false;
    }
}
