package utils;

public class Pair<T, R> {

	// Variables
	
	private T pair1;
	private R pair2;

	// Constructors
	
	public Pair(){
		
	}
	
	public Pair (T pair1, R pair2){
		this.setPair1(pair1);
		this.setPair2(pair2);
	}

	// Getters And Setters
	public T getPair1() {
		return pair1;
	}

	public void setPair1(T pair1) {
		this.pair1 = pair1;
	}

	public R getPair2() {
		return pair2;
	}

	public void setPair2(R pair2) {
		this.pair2 = pair2;
	}

	// Methods
	
	@Override
	public String toString() {
		return "["+this.getPair1().toString()+", "+this.getPair2().toString()+"]";
	}

}
