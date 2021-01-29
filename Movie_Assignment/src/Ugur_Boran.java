import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * This program takes a text file(Movies.txt),reads that file and puts movie data to movie arrayList 
 * after read and take the data it opens a menu for user and user can choose number from the menu so user
 * can list all movies in the arrayList,search a movie and user can find from this program and user can 
 * find highest rated movies.
 * 
 * 
 * @author Ugur
 * @version 1.0
 * @since 2017-12-01
 *
 */

public class Ugur_Boran {
	public static void main(String[] args)throws Exception {

		ArrayList<Movie> Movie_List = new ArrayList<Movie>();//Movie ArrayList


		File file = new File("C:\\Users\\Uður\\Desktop\\movies.txt");//File path
		Scanner file_input = new Scanner(file);// read File

		while(file_input.hasNextLine()){//if file has more line loop will continue 

			Movie movie = new Movie();//create class and initialize


			file_input.next();//next String in file

			movie.setName(file_input.nextLine());//next line is movie name


			file_input.next();
			movie.setDirector(file_input.nextLine());//next line is director name
			//System.out.println(movie.getDirector());

			file_input.next();
			String cast_line = file_input.nextLine();//next line is cast part
			String[] array_cast_line=cast_line.split(",");//after split operation create an string array

			for(int i=0;i<array_cast_line.length;i++){

				movie.cast.add(array_cast_line[i]);//add new cast values to movie class

			}

			file_input.next();
			String type_line = file_input.nextLine();
			String[] array_type_line=type_line.split(",");

			for(int i=0;i<array_type_line.length;i++){
				movie.type.add(array_type_line[i]);

			}

			file_input.next();

			String month = file_input.next();//take string month(for example December)

			String date_line = file_input.nextLine();

			String[] array_date_line = date_line.split(" ");

			file_input.next();
			String time_line = file_input.nextLine();
			String[] array_time_line = time_line.split(" ");

			for(int i=1;i<array_date_line.length;i++){
				for(int j=1;j<array_time_line.length;j++){



					String datestring = array_time_line[j].concat(" "+array_date_line[i].concat("-"+month).concat("-2017"));//date like 14:15 11-December-2017
					SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm dd-MMMM-yyyy",Locale.US);




					try {

						movie.dates.add(dateformat.parse(datestring));//change string type to date type 
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}

			file_input.next();

			movie.setMetascore(Integer.parseInt(file_input.nextLine().trim()));//taking metascore input from string
			//System.out.println(movie.getMetascore());

			Movie_List.add(movie);
		}

		file_input.close();

		System.out.print("=============================\n[1] List All Movies\n[2] Find Movie\n[3] Highest Rated Movies\n[4] Movies in Three Hours\n[5] Add to Watchlist\n[6] Display Watchlist\n[9] << ADD YOUR MENU ITEM >>\n[q] Quit\n=============================\nENTER YOUR CHOICE > ");

		Scanner user_input = new Scanner(System.in);
		int user_choice = user_input.nextInt();
		switch(user_choice){
		case 1:
			System.out.println("Listing movies");
			for(Movie allmovies:Movie_List){
				System.out.println(allmovies);
			}
			break;

		case 2:
			System.out.print("Find by movie name.Enter at least three characters.\nENTER MOVIE NAME:");
			Scanner guess = new Scanner(System.in);
			String guess_string=guess.nextLine();

			for(int i=0;i<Movie_List.size();i++){
				if(Movie_List.get(i).getName().contains(guess_string)){
					System.out.println(Movie_List.get(i));
				}
			}
			break;

		case 3:
			System.out.print("Listing Highest Scored Movies\nENTER MINIMUM METASCORE >");
			Scanner metascore_input = new Scanner(System.in);
			int metascore=metascore_input.nextInt();

			for(int i=0;i<Movie_List.size();i++){
				if(metascore<Movie_List.get(i).getMetascore()){
					System.out.println(Movie_List.get(i));
				}
			}
			break;

		case 4:
		case 5:
		case 6:
		case 9:
		default:
		}
	}
}