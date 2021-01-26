public class ComputePi {
	public static void main(String Args[]){

		int point_count=300000;
		int size_square=400;
		int radius=50;
		int counter=0;
		int i;
		double pi;

		for(i=1;i<=point_count;i++){

			double x=(Math.random()*1);
			double y=(Math.random()*400);
			System.out.println(""+x);

			double distance=Math.pow((x-(size_square/2))*(x-(size_square/2))+(y-(size_square/2))*(y-(size_square/2)),0.5);

			if(distance<radius){
				counter++;
			}	
		}
		pi=(double)((size_square*size_square)*counter)/((radius*radius)*point_count);
		System.out.println("Estimated pi is :"+pi);
	}
}
