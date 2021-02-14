public class TestMyProgram {

	public static void main(String[] args) {
		
		//Coordinate c = new Coordinate(10,20);
		//c.myMethod("input.txt");
		
		//Station[] m2 = new Station[14];
		
		Station p = new Station(8);
		p.setName("Sirkeci");
		p.loc.x = 300;
		p.loc.y = 600;
		
		Station s = new Station();
		s.setName("Taksim");
		s.places[0] = "Harbiye";
		s.places[1] = "Karakoy";
		s.places[2] = "Galata";
		
		System.out.printf("Name of the station: %10s\n", s.getName());
		
	}
	
}