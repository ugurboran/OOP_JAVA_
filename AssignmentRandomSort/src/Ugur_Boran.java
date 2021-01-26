/**
 * Author : Uður Boran
 * Date : 08.03.2017
 * Version : 1.0
 * Summary : Program randomly sort an array in increasing order
 */
import java.util.Scanner;
import java.util.Random;
public class Random_Sort {
	public static void main(String[] args){
		int max_value=100;
		boolean order = false;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int SIZE=input.nextInt();
		int[] array=new int[SIZE];
		System.out.print("Press i for increasing order or d for decreasing order: ");
		String input_order = input.next();
		if(input_order.equals("i")){
			order=true;
		}
		else if(input_order.equals("d")){
			order=false;
		}
		fillArray(array,max_value);//filling array with random numbers
		System.out.println("Array(unsorted):");
		printArray(array);//print unsorted array
		int swap_count=randomSort(array,order);//this will give us random count numbers
		randomSort(array,order);//this method sorts the array
		System.out.println("Array(sorted):");
		printArray(array);//print sorted array 
		System.out.println("Number of swap operations performed:"+swap_count);
	}
	private static void fillArray(int[] array, int max_value) {
		Random random_generator=new Random();
		int i;
		for(i=0;i<array.length;i++){
			int random_value=random_generator.nextInt(max_value+1);
			array[i]=random_value;
		}
	}
	public static void printArray(int[] array) {
		for(int e : array){
			System.out.println(e);
		}
	}
	public static boolean isSorted(int[] array, boolean order){
		int i;
		for(i=0;i<array.length;i++){
			if(array[i]>array[i+1]){
				order=false;
			}
			else if(array[i]<array[i+1]){
				order=true;
			}
		}
		return order;
	}
	public static int randomSort(int[] array, boolean order){
		int i=0;
		while(order==true || order==false){
			Random random_generator=new Random();
			int a=random_generator.nextInt(array.length);
			int b=random_generator.nextInt(array.length);
			int temp;
			if(a<b && array[a]>array[b]){
				temp=array[a];
				array[a]=array[b];
				array[b]=temp;
				break;
			}
			else if(a<b && array[a]<array[b]){
				temp=array[b];
				array[b]=array[a];
				array[a]=temp;
				break;
			}
			i++;
		}
		
		return i;

	}
}
