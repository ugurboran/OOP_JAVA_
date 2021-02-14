/**
 * Author : Uður Boran
 * Date : 21.05.2017
 * Version : 1.0
 * Summary : Program reads metro.txt files.This file contains metro stations,coordinates and destinations that you can go from that station and this 
 * program uses array of objects that is m2,Arraylists and station object so this program uses these informations and shows you how can user go to the
 * destination user entered.Program output shows you the metro stations that you pass for go to the destination.
 */

import java.util.ArrayList;

public class Station {
	public String name;
	public int x;
	public int y;
	
	ArrayList<String> destinations=new ArrayList<>();
	
	Station(){
		name = "empty name";
		x=0;
		y=0;
		destinations.clear();
		}
	
	Station(String name,int x,int y,ArrayList<String> destinations){
		
		this.name=name;
		this.x=x;
		this.y=y;
		this.destinations=destinations;
		
	}
}
