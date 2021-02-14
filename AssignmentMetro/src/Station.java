import java.util.ArrayList;

public class Station {
	
	private String name;
	public String[] places;
	public Coordinate loc;
		
	public void setName(String in) {
		name = in;
	}
	public String getName(){
		return name;
	}
	
	Station(){
		name = "empty name";
		places = new String[10];
		loc = new Coordinate(0,0);
		// loc = new Coordinate();
		// loc.x = 100;
		// loc.y = 100;
	}
	
	Station(int size){
		name = "empty name";
		places = new String[size];
		loc = new Coordinate(0,0);
	}
	

	
	
	

}