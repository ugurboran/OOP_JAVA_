/**
* Author : Uður Boran
* Date : 19.03.2017
* Version : 1.0
* Summary : Program takes gamesTR.text and reads it,then it calcuates the points of the teams.
*/
import java.util.Scanner;
public class Ugur_Boran {
	public static void main(String[] args)throws Exception{

		java.io.File file=new java.io.File("gamesTR.txt");
		final int MAX_POINT = 1000;
		String[] teams = { "Fenerbahce", "Efes", "Besiktas", "Banvit", "Darussafaka", "Galatasaray" };
		String[] teams_1= new String[MAX_POINT];
		int[] scores= new int[MAX_POINT];
		int[] points = new int[MAX_POINT];
		int i=0;
		int j=1;
		for(i=0;i<points.length;i++){
			points[i]=-0;
		}
		Scanner input=new Scanner(file);
		while(input.hasNext()){
			String team=input.next();
			int score=input.nextInt();
			scores[j]=score;
			teams_1[j] = team;
			System.out.println(team+" "+ score);
			j++;
		}
		input.close();

		for(j=1;j<scores.length;j=j+2){
			for(i=0;i<points.length;i=i++){
				if(scores[j-1]>scores[j]){
					points[i]=points[i]+2;
					points[i+1]=points[i+1]+1;
				}
				else if(scores[j-1]<scores[j]){
					points[i+1]=points[i+1]+2;
					points[i]=points[i]+1;
				}
			}
		}
		printStandings(teams, points);
	}
	private static void printStandings(String[] teams, int[] points) {
		int i;
		for(i=0;i<points.length;i++){
			System.out.println(teams[i]+" "+points[i]);
		}
	}
}
