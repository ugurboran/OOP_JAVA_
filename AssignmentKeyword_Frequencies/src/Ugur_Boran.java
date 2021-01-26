import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * This code reads input java files.It has a keyword string array and if input file has that 
 * keyword this program puts this keyword to the Hash set after that keyword repeated, program 
 * add that keyword to Hash map and value of that keyword increasing so program has the count of 
 * the keywords.For sorting,this program calls WordOccurrence class and program uses sort method
 * to sort counts.
 * 
 * 
 * @author Ugur_Boran
 * @version 1.0
 * @since 2017-12-27
 *
 */

public class Ugur_Boran {

	public static void main(String[] args) {

		String[] keyword = { "abstract", "finally", "public", "boolean", "float", "return", "break", "for", "short", "byte", "goto", 
				"static", "case", "if", "super", "catch", "implements", "switch", "char", "import", "synchronized", "class", "instanceof",
				"this", "const", "int", "throw", "continue", "interface", "throws", "default", "long", "transient", "do", "native", "try", 
				"double", "new", "void", "else", "package", "volatile", "extends", "private", "while", "final", "protected", "true", "null" };

		Set<String> keyword_Set = new HashSet<String>();	//create new Hash set
		Collections.addAll(keyword_Set, keyword);	//add String array to Hash set
		HashMap<String,Integer> keyword_Map = new HashMap<String,Integer>();	//create new Hash Map

		try {

			System.out.print("Enter the name of the input Java file:");
			Scanner input = new Scanner(System.in);
			File file = new File(input.nextLine());
			input = new Scanner(file);
			String text ="";

			while (input.hasNext()) {
				String line = input.nextLine() + " ";
				if(line.contains("//")){	//if line is comment line it will be removed

					String comment = line.substring(line.lastIndexOf("//")+1);
					line = line.replace(comment, "" );

				}

				text = text.concat(line + " ");

			}

			String[] symbols = text.split("[ \\[,.()\\]]");	// text will be split from these symbols
			for(String symbol : symbols){
				symbol = symbol.trim();
				if(keyword_Set.contains(symbol)){	// if Hash set contains keyword
					if(keyword_Map.get(symbol) == null){	//if Hash map is empty control
						keyword_Map.put(symbol,1);	//it will add the first key to the Hash Map and value will be 1
					}
					else {	//otherwise 
						int count = keyword_Map.get(symbol); 	//count will be value in the Hash map
						count++;	//count will decrease
						keyword_Map.put(symbol, count);	 //new value in the Hash map will be count so Hash Map value holds count of every Hash Map key
					}
				}
			}


			Set<Map.Entry<String, Integer>> entrySet = keyword_Map.entrySet();	// Get all entries into a set from Hash Map

			ArrayList<WordOccurrence> pair_list=new ArrayList<WordOccurrence>();	//create an (WordOccurrence Class)ArrayList named pair_list

			for(Map.Entry<String,Integer> entrySet_value:entrySet){		//loop all entries in the set

				WordOccurrence word = new WordOccurrence(entrySet_value);	//Create new Class with Map(key,value)	
				pair_list.add(word);	//add class to ArrayList

			}

			Collections.sort(pair_list);	//sort ArrayList

			System.out.println("Keyword Frequencies in Descending Order");

			for(WordOccurrence key_value : pair_list){	//Print all keys and values in the Hash Map
				System.out.println(key_value);
			}

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}