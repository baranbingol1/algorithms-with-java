//Q: How to find sum of digits recursively?
class sumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(12));
    }
    public static int sumOfDigits(int n){
        if(n == 0){
            return 0;
        } 
        return n % 10 + sumOfDigits(n/10);
    }
}
