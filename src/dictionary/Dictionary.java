package dictionary;

import java.util.Vector;

import dictionary.chunk.Chunk;

public interface Dictionary {
	
	// Methods
	
	/**
	 * 
	 * @param text El parametro text es el texto a ser analizado.
	 * @param debugMode El parametro debugMode denota si el modo debug se usara.
	 * @return El metodo recognize retorna un vector de las identidades reconocidas.
	 */

	public Vector<Chunk> recognize(String text, boolean debugMode);
		
}
