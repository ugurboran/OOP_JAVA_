import java.util.ArrayList;

public class Station {
	public String name;
	public int x;
	public int y;
	ArrayList<String> destinations=new ArrayList<>();
	
	Station(){
		name = "default";
		x = 0;
		y= 0;
		destinations.clear();
	}
	
	Station(String name, int x, int y, ArrayList<String> destinations){
		this.name = name;
		this.x = x;
		this.y = y;
		this.destinations = destinations;
	}
	
}
