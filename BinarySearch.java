package algorithms;


public class BinarySearch {

    public static int BinarySearchIteratively(int[] arr, int target){

        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int middle = (start+end)/2;
            if(arr[middle] == target){
                return middle;
            }
            else if (arr[middle] < target){
                start = middle + 1;
            }
            else if(arr[middle] > target){
                end = middle - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Binary Search'ün çalışabilmesi için verilen veri yapısının sıralanmış halde olması gerek.
        int[] test = {2,5,7,11,43,89};
        int target = 11;
        System.out.println(target + " elemani dizi de " + BinarySearchIteratively(test,target) + ". indekste");
        target = 2;
        System.out.println(target + " elemani dizi de " + BinarySearchIteratively(test,target) + ". indekste");
        target = 99;
        System.out.println(target + " elemani dizi de " + BinarySearchIteratively(test,target) + ". indekste");
    }
}
