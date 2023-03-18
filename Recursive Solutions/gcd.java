//Q: How to find Greatest Common Divisor of two numbers using recursion?
class gcd {
    public static void main(String[] args) {
       System.out.println(gcd(96,48));
       System.out.println(gcd(12,9));
       System.out.println(gcd(55,11));
       System.out.println(gcd(99,99));
       System.out.println(gcd(12,24));
    }
    public static int gcd(int n1, int n2){
        if(n1 < n2){
            return -1;
        }
        if(n1==n2){
            return n1;
        }
        //We are going to use Euclidean algorithm.
        if(n2==0){
            return n1;
        }
        return gcd(n2,(n1%n2));
    }
}