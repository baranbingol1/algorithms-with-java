package algorithms;

public class insertionSort {

	//insertion sortu anlayabilmek için önce insertion mantığını fonksiyona dökelim...
	//bu fonksiyon istenilen sayıyı sıralanmış array'e ekleyecek.
	//sondan başa doğru gidecek bir pointer bize sayının nereye yerleştirileceğini söyleyecek.
	//yerleştirileceği yerdeki ve sonraki elemanları arrayde bir adım sağa öteleyeceğiz(bunu yapmak için boyutu bir önceki arrayin bir fazlası olan bir array oluşturacağız).
	
	public static int[] insertion(int[] list, int number) { // O(n) -> ZAMAN KARMASIKLIGI
		
		int len = list.length;
		int[] newList = new int[len+1];//yeni arrayimiz.
		
		int position = 0;//sayının ekleneceği yer
		
		// i -> sondan başa gelecek olan pointer
		for(int i = len - 1 ; i>=0 ; i--) {
			if(list[i] < number) {
				position = i+1;
				break;
			}
		}
		
		//önceki elemanları da yeni listemize kopyalayalım.
		for(int i = 0 ; i < position ; i++) {
			newList[i] = list[i];
		}
		//elemanımızı yerine yerleştirelim.
		newList[position] = number;
		//sonraki elemanları yerleştirelim.
		for(int i = position + 1 ; i < len + 1 ; i++) {
			newList[i] = list[i-1];
		}
		
		return newList;
	}
	
	//insertion sort yukarıdaki fonksiyonda gösterilen insertion mantığının arrayin elemanlarının kendi içinde sırayla insert edilmesiyle çalışır.
	//ilk elemanı atlarız.
	//arrayin ikinci elemanını arrayin 1. elemanından 2. elemanına olan kısmına insert ederiz..
	//sonra arrayin üçüncü elemanını arrayin 1. elemanından 3. elemanına olan kısmına insert ederiz..
	//sonra arrayin dördüncü elemanını arrayin 1. elemanından 4. elemanına olan kısmına insert ederiz..
	//bu şekilde son elemana kadar işlemleri yaparız.
	
	public static int[] insertionSort(int[] list) { // O(n^2) -> ZAMAN KARMASIKLIGI
		
		int len = list.length,j,tmp,number;
		
		for(int i = 1 ; i < len ; i++) {
			number = list[i];
			j = i-1;
			while(j>=0 & list[j] > number) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = number;
		}
		return list;
	}
	
	public static void main(String[] args) {
		
		//insertion test:
		int[] myList = {2,4,5,7,8,9};
		int number = 6;
		
		int[] mySortedList = insertion(myList, number);
		
		for(int i : mySortedList)
			System.out.print(i + " ");
		
		//diğer test için yeni satır
		System.out.print("\n");
		
		//insertion sort test:
		int[] myList2 = {2,4,9,5,7,8};
		
		
		int[] mySortedList2 = insertionSort(myList);
		
		for(int i : mySortedList2)
			System.out.print(i + " ");
		
	}
	//insertion sort algoritmasını linked list üzerinde kullanmak daha doğru olacaktır.
	//çünkü arrayler üzerinde kullanmak arrayin içinde shifting yapmayı gerektirir ve bu bize ekstra bir işlem karmaşıklığı verir. linked listlerde bu sıkıntı yoktur.
}
