/**
 * Author : Uður Boran
 * Date : 09.04.2017
 * Version : 1.0
 * Summary : Program reads circles.txt files and put the data into double array and uses this data and calculates the maximum distance between circles and shows in the scene.
 */
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Uður_Boran extends Application {

	public void start(Stage primaryStage) throws FileNotFoundException {
		Pane pane = new Pane();
		double x1=0,x2=0,y1=0,y2=0;
		int circlenumber1=0,circlenumber2=0;
		double distance = 0;
		double[][] circlearray=readCircles(	"Circles3.txt");
		printCircles(circlearray);
		double max_distance=Math.pow( ( (circlearray[0][0]-circlearray[1][0]) * (circlearray[0][0]-circlearray[1][0]) + (circlearray[0][1]-circlearray[1][1]) * (circlearray[0][1]-circlearray[1][1]) ) ,0.5);

		for(int i=0;i<circlearray.length-1;i++){
			
			for(int j=i+1;j<circlearray.length-1;j++){
				distance=Math.pow( ( (circlearray[i][0]-circlearray[j][0]) * (circlearray[i][0]-circlearray[j][0]) + (circlearray[i][1]-circlearray[j][1]) * (circlearray[i][1]-circlearray[j][1]) ) ,0.5);
				if(distance>max_distance){
					max_distance=distance;
					x2=circlearray[i][0];
					x1=circlearray[j][0];
					y2=circlearray[i][1];
					y1=circlearray[j][1];
					circlenumber1=i;
					circlenumber2=j;
				}
			}
		}
		System.out.println(" Maximum Distance between "+circlenumber1+" and "+circlenumber2+" is "+max_distance);
		// double[][] circles = readCircles("circles3.txt");
		// display the result on the console
		// plot the drawings

		for(int k=0;k<circlearray.length;k++){
			double x=circlearray[k][0];
			double y=circlearray[k][1];
			double radius=circlearray[k][2];
			Circle circle = new Circle(x,y,radius);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);
			circle.setOpacity(0.9);
			circle.setStrokeWidth(1);
			pane.getChildren().add(circle);

		}

		// Line class is used to draw lines in JavaFX
		Line line = new Line(x1, y1, x2, y2);
		line.setStroke(Color.RED);
		line.setStrokeWidth(1);
		pane.getChildren().add(line);
		Text t = new Text ((x2-x1)/2,(y2-y1)/2, " "+max_distance);
		pane.getChildren().add(t);


		// use JavaFX Text class to write text on the drawing

		Scene scene = new Scene(pane, 800, 800);
		primaryStage.setTitle("Maximum Circle Distance"); // Set the stage title
		primaryStage.setResizable(false);
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}


	public static void main(String[] args) {
		launch(args);
	}
	public static double[][] readCircles(String Circles3) throws FileNotFoundException {
		int MAX_COUNT=1000;
		double[][] circles= new double[MAX_COUNT][3];

		for(int i=0;i<circles.length;i++){
			circles[i][2]=-1;
		}
		java.io.File circles3=new java.io.File(Circles3);
		Scanner input=new Scanner(circles3).useLocale(Locale.US);
		int counter=0;
		while(input.hasNext()){
			String temp=input.next();
			circles[counter][0]=input.nextDouble();
			circles[counter][1]=input.nextDouble();
			circles[counter][2]=input.nextDouble();
			counter++;
		}
		return circles;
	}

	public static void printCircles(double[][] circles){

		for(int i=0;i<circles.length;i++){
			if(circles[i][2]==-1){
				break;
			}
			for(int j=0;j<circles[i].length;j++){
				System.out.print(i+1+". "+circles[i][j]);
			}
			System.out.println();

		}
	}
}
