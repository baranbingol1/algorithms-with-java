package algorithms;
/*                                                         TimSort Özellikleri
Bu algoritma merge sort ve insertion sort'u beraber kullanan hibrit bir sıralama algoritmasıdır.
Verilen array'i 'Run' denilen bloklara ayırırız ve bu blokları tek tek insertion sort ile sıralayıp
bu blokları merge sortta kullandığımız merge fonksiyonu ile tekrardan birleştiririz.
Stabil bir algoritmadır.In-place değildir ekstra memory space'e ihtiyaç duyar.
Bu algoritma python'ın sort ve sorted methodlarında ve java'nın sort methodunda kullanılır.
Algoritmanın zaman karmaşıklığı(time complexity):
Best case -> O(n) (Böylece merge sort'un best case'ini zaman karmaşıklığı bakımından yeniyor)
Worst case -> O(nlogn)
Algoritmanın uzay karmaşıklığı(space complexity) -> O(n)
*/
public class TimSort {

/*Algoritmanın insertion sort ve merge sorttaki merge algoritmasının beraber kullandığını söylemiştik.
Bu yüzden öncelikle onları yazalım.
*/
    //Insertion Sort algoritması
    public static void insertionSort(int[] arr, int beg, int end){
        int i, j, temp;
        for (i = beg + 1; i <= end; i++) {
            temp = arr[i];
            j = i - 1;

            while(j>=beg && temp <= arr[j])
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = temp;
        }
    }
    //Sıralanmış 'Run'lar için merge fonksiyonu
    public static void merge(int[] arr, int beg, int mid, int end){
        int i = 0,j = 0,k = 0;
        //Geçici oluştaracağımız arraylerin boyutları
        int n1 = mid - beg + 1;
        int n2 = end - mid;
        //Geçici arrayler
        int[] lArr = new int[n1];
        int[] rArr = new int[n2];
        //Geçici arraylerin doldurulması
        for(int a = 0 ; a < n1 ; a++)
            lArr[a] = arr[beg+a];
        for(int a = 0 ; a < n2 ; a++)
            rArr[a] = arr[mid+1+a];
        //Merge algoritması
        while(i < n1 && j < n2){
            if(lArr[i] <= rArr[j])
                arr[k++] = lArr[i++];
            else
                arr[k++] = rArr[j++];
        }
        while(i < n1){
            arr[k++] = lArr[i++];
        }
        while(j < n2){
            arr[k++] = rArr[j++];
        }

    }
    //TimSort algoritmasının implemente edilmesi

    //Kullanacağımız minimum bulma methodunun implemente edilmesi
    //Bu method for döngüsünün içinde (i+run_size-1)'in array'in maximum index'ini aştığı durumu engellemek için var.
    public static int min(int a, int b){
        if(a < b)
            return a;
        else
            return b;
    }
    public static void timSortAlgorithm(int arr[], int n, int run_size){
        //Subarrayleri sıralama işlemi
        for(int i = 0 ; i < n ; i+=run_size){
            insertionSort(arr,i,min((i+run_size-1),(n-1)));
        }
        //Merge işleminin başlaması
        for(int size = run_size; size < n; size *= 2){
            //Soldaki sub-array'in bitişini ve sağdaki sub-array'in başlangıcını bul
            for(int beg = 0; beg < n;beg+=2*size){
                int mid = beg + size - 1;
                int end = min((beg+2*size-1),(n-1));

                //Sub array'i merge et
                if(mid < end)
                    merge(arr, beg, mid, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {40, 12, 31, 27, 25, 8, 1, 32, 17};
        int n = a.length;
        int run_size = 4;
        timSortAlgorithm(a, n, run_size);
        for(int i : a)
            System.out.println(i + " ");
    }
}

//Kaynakça : https://www.javatpoint.com/tim-sort
