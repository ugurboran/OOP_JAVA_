import java.util.Scanner;

public class ComputeAreaInteractive {
	public static void main(String Args[]){
		
		double area;
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter a radius:");
		
		double radius=scanner.nextDouble();
		
		area=radius*radius*3.14159;
		
		System.out.println("The radius is "+radius+" and the area of the circle is "+area);
		
		
	}

}
