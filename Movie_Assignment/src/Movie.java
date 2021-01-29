
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
/**
 * This class for the data that we take from the movies.txt
 * 
 * 
 * @author uður
 * @version 1.0
 * @since 2017-12-01
 */
public class Movie  {

	private String name;
	private String director;
	public ArrayList<String> cast = new ArrayList<>();
	public ArrayList<String> type = new ArrayList<>();
	public ArrayList<Date> dates = new ArrayList<>();
	private int metascore;

	public Movie(){

	}

	public Movie(String name,String director,ArrayList<String> cast,ArrayList<String> type,ArrayList<Date> dates,int metascore){
		this.name=name;
		this.director=director;
		this.cast=cast;
		this.type=type;
		this.dates=dates;
		this.metascore=metascore;
	}
	/*@param take name from file
	 * 
	 */
	public void setName(String input) {
		this.name = input;
	}
	/*
	 * @return name of movie
	 */
	public String getName(){
		return name;
	}
	/*@param take director from file
	 * 
	 */
	public void setDirector(String input) {
		this.director = input;
	}
	/*
	 * @return director of movie
	 */
	public String getDirector(){
		return director;
	}
	/*@param highest rate from file
	 * 
	 */
	public void setMetascore(int input) {
		this.metascore = input;
	}
	/*
	 * @return highest rate of movie
	 */
	public int getMetascore(){
		return metascore;
	}



	public String toString(){


		//SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm dd MMMM yyyy",Locale.US);
		return String.format("Name :%s\nDirector : %s\nCast :%s\nType:%s\nMetascore:%d", this.name,this.director,this.cast,this.type,this.metascore);
	}


}