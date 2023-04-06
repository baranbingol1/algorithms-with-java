package algorithms;
/*                                          Quick Sort Özellikler, Avantajları, Dezavantajları
Recursive yazılan bir algoritmadır.
Best case O(nlogn) olan bir algoritmadır.
Worst case O(n^2)'dir.
Ekstra memory space kullanmaz(in-place'tir) ancak recursive olarak yazılan bir algoritma olduğu için fonksiyon stack'ini doldurur.
Fonksiyon stack'i en iyi ihtimalle logn derinliğinde en kötü ihtimalle n derinliğinde olur.
Quick Sortta base case'i sağlamak için 2 şey yapılabilir:
1 - Pivot'u her zaman array'in ortasındaki eleman seçmek.
2 - Pivot'u her zaman rastgele seçmek.
Bu iki yöntemde bize kesin olarak best case scenario'yu sağlatmaz.
*/
public class QuickSort {
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low, j = high;
        while(i < j){

            do{
                i++;
            } while(arr[i] <= pivot);

            do{
                j--;
            } while(arr[j] > pivot);

            if(i < j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

        }

        int tmp = arr[low];
        arr[low] = arr[j];
        arr[j] = tmp;

        return j;
    }

    public static void QuickSortAlgorithm(int[] arr, int low, int high){
        if(low < high){
            int j = partition(arr, low, high);
            QuickSortAlgorithm(arr,low, j);
            QuickSortAlgorithm(arr,j+1,high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,5,8,9,3,6,15,12,16};
        int n = arr.length;
        QuickSortAlgorithm(arr,0,n-1);
        System.out.println("Sorted array: ");
        for(int i : arr)
            System.out.print(i + " ");
    }
}
