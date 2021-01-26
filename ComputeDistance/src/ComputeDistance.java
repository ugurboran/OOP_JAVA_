import java.util.Scanner;

public class ComputeDistance {

	public static void main(String Args[]){
		Scanner input=new Scanner(System.in);

		System.out.println("Enter the coordinates of p1:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();

		System.out.println("Enter the coordinates of p2:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();

		double a=(x2-x1)*(x2-x1);
		double b=(y2-y1)*(y2-y1);

		double distance=Math.sqrt(a+b);
		System.out.println("The distance between two point is : " +distance);
	}
}
