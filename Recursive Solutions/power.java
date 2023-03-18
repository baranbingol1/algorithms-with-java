//Q: Find given power of a given number with recursion
class power {
    public static void main(String[] args) {
        System.out.println(power(4,4));
    }
    public static int power(int base, int exp){
        if(exp==0){
            return 1;
        }
        return base*power(base,exp-1);
    }
}