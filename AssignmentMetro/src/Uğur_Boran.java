/**
 * Author : Uður Boran
 * Date : 09.04.2017
 * Version : 1.0
 * Summary : Program reads metro.txt files.This file contains metro stations,coordinates and destinations that you can go from that station and this 
 * program uses array of objects that is m2,Arraylists and station object so this program uses these informations and shows you how can user go to the
 * destination user entered.Program output shows you the metro stations that you pass for go to the destination.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Uður_Boran {
	public static void main(String[] args)throws Exception{
		Station[] m2=new Station[15];
		java.io.File file=new java.io.File("metro.txt");
		int counter1=0;
		int counter2;
		int counter3;
		int counter4;
		Scanner input=new Scanner(file);
		while(counter1<15){
			String str = input.nextLine();
			String[] strParts = str.split(":");
			m2[counter1]=new Station();
			m2[counter1].name= strParts[0];
			m2[counter1].x= Integer.parseInt(strParts[1]);
			m2[counter1].y= Integer.parseInt(strParts[2]);
			for(counter3=3;counter3<strParts.length;counter3++){
				m2[counter1].destinations.add(strParts[counter3]);
			}
			counter1++;
		}
		Scanner input_str=new Scanner(System.in);
		System.out.print("Where would you like to go ? :");
		String str=input_str.next();
		ArrayList<Integer> position_stations=new ArrayList<>();
		position_stations=findDestination(m2,str);
		if(position_stations.isEmpty()==true){
			System.out.println("No stations found for the destination!");
			
		}
		else{
			System.out.println("Metro Stations from ITU to destination: ");
		}
		for(counter2=0;counter2<position_stations.size();counter2++){
			if(position_stations.get(counter2)<3){
				for(counter4=3;counter4>=position_stations.get(counter2);counter4--){
					System.out.print("  ["+m2[counter4].name+"]  ");
				}
			}
			else if(position_stations.get(counter2)>3){
				for(counter3=3;counter3<=position_stations.get(counter2);counter3++){
					if(m2[counter3].name.equals("ITU")){
						System.out.println();
					}
					System.out.print("  ["+m2[counter3].name+"]  ");
				}
			}
		}
	}
	public static ArrayList<Integer> findDestination(Station[] m2,String str){
		ArrayList<Integer> List=new ArrayList<>();
		for(int i=0;i<m2.length;i++){
			if(m2[i].destinations.contains(str))
				List.add(i);
			
		}
		return List;
	}
}
