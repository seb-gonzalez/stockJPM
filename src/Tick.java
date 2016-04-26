import java.util.ArrayList;
import java.util.Random;

public class Tick {
	private String stock;
	private boolean direction; //UP = TRUE,  DOWN = FALSE
	private double tickerPrice; //current value of the stock
	private double changeAmount; //difference in price from the previous day
	
	public Tick(String stock) {
		this.stock = stock;
		this.direction = true; //by default the tick will go up!
		this.tickerPrice = 0.0;
		this.changeAmount = 0.0;
	}
	
	
	private int randomInteger(int min, int max) {

	    Random rand = new Random();

	    
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    

	    return randomNum;
	}
	
	private double randomDouble(double min, double max) {

		Random r = new Random();
		double randomValue = min + (max - min) * r.nextDouble();
	    

	    return Math.round (randomValue * 1000.0) / 1000.0;  
	}
	
	
	private boolean generateDirection() {
		return randomInteger(0,1) == 0 ? true : false;
	}
	
	//TODO
	private double generateTickerPrice() {
		
	    

	    return randomDouble(changeAmount, this.direction ? changeAmount+1.0 : changeAmount - 1.0);
	}
	
	private void updateChangeAmount() {
		this.changeAmount = Math.round ((tickerPrice - changeAmount) * 1000.0) / 1000.0;  
	}
	
	public ArrayList<String> produceTick() {
		
		ArrayList<String> result = new ArrayList<String>();
		this.direction = generateDirection();
		this.tickerPrice = generateTickerPrice();
		this.updateChangeAmount();
		
		result.add(this.stock);
		result.add(this.direction == true ? "UP" : "DOWN");
		result.add(this.tickerPrice + "");
		result.add(this.changeAmount + "");
		
		return result;
	}

}
