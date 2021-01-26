//Uður Boran
/*import java.io.*;

public class readdatafromtext {
	public static void main(String [] args) {
		// The name of the file to open.
		String fileName = "C:/data%281%29.txt";
		String line = null;
		try {
			FileReader fileReader = 
					new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}   
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");                  
		}
		 public static ArrayList<String> get_arraylist_from_file(File f) 
			        throws FileNotFoundException {
			        Scanner s;
			        ArrayList<String> list = new ArrayList<String>();
			        s = new Scanner(f);
			        while (s.hasNext()) {
			            list.add(s.next());
			        }
			        s.close();
			        return list;
			    }
	}
}*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readdatafromtext {
    public static void main(String[] args) {
    File f = new File("D:/data%281%29.txt");
        try{
            ArrayList<String> lines = get_arraylist_from_file(f);
            for(int x = 0; x < lines.size(); x++){
                System.out.println(lines.get(x));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("done");

    }
    public static ArrayList<String> get_arraylist_from_file(File f) 
        throws FileNotFoundException {
        Scanner s;
        ArrayList<String> list = new ArrayList<String>();
        s = new Scanner(f);
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return list;
    }
}