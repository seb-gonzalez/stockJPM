import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
	public static void main(String[] args) {
		System.out.println("JP Morgan Test - Sebastian Gonzalez\n\n");
		Tick tick = new Tick("TEA");
		
		ArrayList<ArrayList<String>> realTimeData = new ArrayList<ArrayList<String>>();
		
		//We produce a range of 10 samples in through the 'time' - mocked version of real time system
		for(int i=0; i<10; i++) {
			realTimeData.add(tick.produceTick());
		}
		
		
		/* Once we have produced a short sample of tick values we then
		 * see how the stock behaves and which are their results...
		 * 
		 * We will pass the last sample [9] to analize the values...
		 * */
		
		Stock stock = new Stock(realTimeData.get(9));
		stock.calculateValues();
		
		System.out.println("Last sample from real time data generated: [Stock name, direction, ticker price, change Amount] " + realTimeData.get(9));
		
		System.out.println("Stock:          " + stock.getName() +
				"\nDividend Yield: " + stock.getDividend_yield() + 
				"\nP/E Ratio:      " + stock.getRatio());
		
		stock.recordTrade("buy", 10, 10.5);
		stock.recordTrade("buy", 1, 2.5);
		stock.recordTrade("buy", 4, 1.5);
		
		
		
		
	}
}
