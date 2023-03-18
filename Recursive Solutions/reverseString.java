//Q:Reverse a string by using recursion
public class reverseString {
    public static void main(String[] args){
        System.out.println(reverse("Hello, world!"));
    }
    public static String reverse(String str)
    {
        if(str.isEmpty()){
            return str;
        }
        else{
            return reverse(str.substring(1))+str.charAt(0);
        }   
    }
}
