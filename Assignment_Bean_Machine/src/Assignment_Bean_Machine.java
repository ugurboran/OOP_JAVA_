import java.util.Scanner;

public class Assignment_Bean_Machine {
	public static void main(String Args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Slot size:");
		int slot_size=input.nextInt();
		System.out.print("Enter the number of balls:");
		int number_balls=input.nextInt();
		int number_nails=slot_size;
		boolean[] storeballs_array=new boolean[slot_size];
		for(int i=0;i<number_balls;i++){
			System.out.println("position_array[i]"+position_array(number_balls,number_nails));
		}
	}
	public static int[] position_array(int number_balls,int number_nails){
		double direction=(Math.random()*10)%2;
		
		int count;
		for(int i=0;i<number_balls;i++){
			for(int j=0;j<number_nails;j++){
				if(direction>0)
					count=1;
				else
					count=0;
			}
		return position_array[];
		}

	}
}
