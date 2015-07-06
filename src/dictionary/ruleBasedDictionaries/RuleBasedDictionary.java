package dictionary.ruleBasedDictionaries;

import java.util.Vector;

import org.apache.log4j.Logger;
import dictionary.Dictionary;
import dictionary.chunk.Chunk;


public class RuleBasedDictionary implements Dictionary {

	// Variables
	
	private Vector<RegExMatcher> matchers;
	
	// Constructors
	
	public RuleBasedDictionary(Vector<RegExMatcher> matchers){
		this.matchers = matchers;
	}
	
	public RuleBasedDictionary(){
		this.matchers = new Vector<RegExMatcher>();
	}
	
	// Getters And Setters
	
	public Vector<RegExMatcher> getMatchers() {
		return matchers;
	}

	public void setMatchers(Vector<RegExMatcher> matchers) {
		this.matchers = matchers;
	}
	
	// Methods
	
	public void addMatcher(RegExMatcher matcher){
		matchers.add(matcher);
	}

	public Vector<Chunk> recognize(String text, boolean debugMode){
		if (debugMode){
			Logger.getLogger(RuleBasedDictionary.class).info("Recognition Started");
		}
		
		Vector<Chunk> out = new Vector<Chunk>();
		for (RegExMatcher matcher : matchers){
			out.addAll(matcher.recognize(text));
		}
		
		if (debugMode){
			Logger.getLogger(RuleBasedDictionary.class).info("Chunks Found:");
			for (Chunk chunk : out)
				Logger.getLogger(RuleBasedDictionary.class).info(chunk.toString());
			Logger.getLogger(RuleBasedDictionary.class).info("Rule Based Dictionary Finished\n");
		}
			
		return out;
	}
	
}
