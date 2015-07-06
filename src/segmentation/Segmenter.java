package segmentation;

import java.util.StringTokenizer;
import java.util.Vector;

public class Segmenter {

	// Variables
	
	private String text;
	private Vector<String> tokens;
	private int lastTokenStartPosition;
	private int lastTokenEndPosition;
	private int actualTokenPosition;
	private boolean caseSensitive;
	
	// Constructors
	
	public Segmenter(String text, boolean caseSensitive){
		this.text = text;
		this.lastTokenStartPosition = 0;
		this.lastTokenEndPosition = 0;
		this.actualTokenPosition = 0;
		this.caseSensitive = caseSensitive;		
		this.tokens = getSegmentation(text);
	}

	// Getters And Setters
	
	public Vector<String> getSegmentation(){
		return tokens;
	}
	
	public int getLastTokenStartPosition() {
		return lastTokenStartPosition;
	}

	public int getLastTokenEndPosition() {
		return lastTokenEndPosition;
	}

	public String getText() {
		return text;
	}
	
	// Methods

	public static Vector<String> getSegmentation(String text){
		Vector<String> out = new Vector<String>();
		StringTokenizer st = new StringTokenizer(text);
		while( st.hasMoreTokens() ){
				out.add(st.nextToken());
		}
		return out;
	}
	
	public static Vector<String> getSegmentation(String text, boolean caseSensitive, boolean onlyCharacters){
		Vector<String> out = new Vector<String>();
		StringTokenizer st = new StringTokenizer(text);
		while( st.hasMoreTokens() ){
			String toAdd = st.nextToken();
			if (onlyCharacters)
				toAdd = toAdd.replaceAll("[^A-Za-z0-9]+", "");
			if (!caseSensitive)
				toAdd = toAdd.toLowerCase();
			out.add(toAdd);
		}
		return out;
	}

	public String getNextToken(){
		if (actualTokenPosition < tokens.size()){
			String actualToken = tokens.get(actualTokenPosition);
			lastTokenStartPosition = text.indexOf(actualToken,lastTokenEndPosition);
			if (!caseSensitive)
				actualToken = actualToken.toLowerCase();
			actualTokenPosition++;
			lastTokenEndPosition = lastTokenStartPosition + actualToken.length();
			return actualToken;	
		}
		else
			return null;
	}

	public void resetPositionToStart(){
		this.actualTokenPosition = 0;
	}

}
