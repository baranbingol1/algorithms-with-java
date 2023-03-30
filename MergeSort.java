package algorithms;

/*                                          Merge Sort Özellikler, Avantajları, Dezavantajları
Merge Sort stable bir algoritmadır, merge etme işlemi O(n), merge edip sıralama işlemi O(nlogn) zaman karmaşıklığına sahiptir.
Merge Sort linked listler için daha uygundur(Üçüncü bir linked list oluşturmadan iki linked list sıralanabilir.).
Merge ile büyük boyuttaki verileri RAM'e ikişer ikişer çekip sıralayıp tekrardan hard diske koyabiliriz böylece sıralamış oluruz.
Merge sort inplace sorting algoritmalarından değildir, ekstra memory space'e ihtiyaç duyar.
Küçük boyuttaki sıralama problemleri için insertion sort daha hızlıdır. Merge Sort recursion işlemiyle zaman kaybeder.(Yaklaşık olarak n<=15 değerleri için)
Bu iki algoritma(insertion ile merge sort) ikisi de stable olduğu için ve linked listler üzerinde daha etkili oldukları için
birlikte kullanılabilir, küçük boyutlar için insertion sort kullanılıp merge edilebilir.
*/
public class MergeSort {


        public static void merge(int[] a, int[] l, int[] r, int left, int right){
            int i = 0, j = 0, k = 0;
            while(i < left && j < right){
                if(l[i] <= r[j]){
                    a[k++] = l[i++];
                } else{
                    a[k++] = r[j++];
                }
            }
            while(i < left){
                a[k++] = l[i++];
            }
            while(j < right){
                a[k++] = r[j++];
            }
        }
        public static void mergeSort(int[] a, int n){
            if(n < 2){
                return;
            }
            int mid = n / 2;
            int[] l = new int[mid];
            int[] r = new int[n - mid];
            for(int i = 0 ; i < mid ; i++){
                l[i] = a[i];
            }
            for(int i = mid ; i < n ; i++){
                r[i-mid] = a[i];
            }
            mergeSort(l, mid);
            mergeSort(r, n - mid);
            merge(a,l,r,mid,n-mid);
        }
        public static void main(String[] args) {

            int arr[] = {8,45,23,11,5,2};

            mergeSort(arr, arr.length);

            for(int i : arr)
                System.out.print(i + " ");

        }
}
