import java.util.Map.Entry;

/**
 *This class created for sorting counts of the words in the Hash Map
 *and uses generic Comparable interface.
 * 
 * 
 * @author Ugur_Boran
 * @version 1.0
 * @since 2017-12-27
 *
 */

public class WordOccurrence implements Comparable<WordOccurrence>{
	
	private String word;
	private int count;

	public WordOccurrence(){ //Default Constructor
		
	}
	public WordOccurrence(Entry<String, Integer> entrySet_value){	//Constructor with Key and Value from Hash Map
		
		this.word = entrySet_value.getKey();
		this.count = entrySet_value.getValue();
	}

	public String getWord(){
		
		return word;
	}

	public int getCount(){
		
		return count;
		
	}
	
	@Override
	public int compareTo(WordOccurrence wo) {	//Compare values in the Hash Map
		
		if(getCount() > wo.getCount())
			return -1;
		else if(getCount() < wo.getCount())
			return 1;
		else
			return 0;
		
	}
	
	@Override
	public String toString(){	//Print Key and Value to the screen
		
		String str = String.format("%-11s : %d", getWord(),getCount());
		return str;
	}
}