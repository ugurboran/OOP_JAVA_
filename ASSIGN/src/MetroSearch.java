
import java.util.ArrayList;
import java.util.Scanner;

public class MetroSearch {

	public static void main(String[] args)throws Exception {

		Station[] M2 = new Station[15];
		java.io.File file = new java.io.File("metro.txt");
		Scanner input = new Scanner(file);
		ArrayList<String> destinations = new ArrayList<>();

		for(int i = 0; i < M2.length; i++){
			String str = input.nextLine();
			String[] strParts = str.split(":");
			M2[i] = new Station();
			String input_name = strParts[0];
			int X = Integer.parseInt(strParts[1]);
			int Y = Integer.parseInt(strParts[2]);

			for(int j = 3; j < strParts.length; j++){
				
				destinations.add(strParts[j]);
				
			}
			
		}
		System.out.println("Where would you like to go? : ");
		Scanner in = new Scanner(System.in);
		String name = in.next();

		ArrayList<Integer> result = findDestination(name, M2);
		
		if(result.isEmpty()==false){
			System.out.println("Metro Stations from ITU to destination: \n");
			int spot = 0;
			switch(spot){
			case 0: case 1: case 2:
				for(int k = 3; k >= result.get(0); k--){
					System.out.println("["+ M2[k]+"]");
				}
			case 3:
				System.out.println("You do not need to take the metro, you are already at the station for the destination!");

			case 4: case 5: case 6: case 7:
			case 8: case 9: case 10: case 11:
			case 12: case 13: case 14:
				for(int l = 3; l <= result.get(0); l++){
					System.out.println("["+M2[l]+"]");
				}
			}
		}
		else{
			System.out.println("NOOO");
		}
		
	}

	public static ArrayList<Integer> findDestination(String name, Station[] m2) {
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0; i < m2.length; i++){
			if(m2[i].destinations.contains(name)){
				result.add(i);
			}
		}
		return result;
	}
}