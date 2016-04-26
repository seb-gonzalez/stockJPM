import java.sql.Timestamp;
import java.util.ArrayList;

public class Stock {

	private String stock;
	private double dividend_yield;
	private ArrayList<ArrayList<String>> trades;

	private double ratio; // P/E ratio
	private double current_tickerPrice;

	private String type;
	private int last_dividend;
	private double fixed_dividend;
	private int par_value;
	
	// private boolean stockPrice; Calculate Stock price based on trades
	// recorded in past 15 minutes*     ???

	public Stock(ArrayList<String> realTimeData) {
		this.stock = realTimeData.get(0);
		this.dividend_yield = 0.0;
		this.ratio = 0.0;
		this.current_tickerPrice = Double.parseDouble(realTimeData.get(2));

		switch (this.stock) {
		case "TEA":
			this.type = "Common";
			this.last_dividend = 0;
			this.fixed_dividend = 0.0;
			this.par_value = 100;
			break;
		case "POP":
			this.type = "Common";
			this.last_dividend = 8;
			this.fixed_dividend = 0.0;
			this.par_value = 100;
			break;
		case "ALE":
			this.type = "Common";
			this.last_dividend = 23;
			this.fixed_dividend = 0.0;
			this.par_value = 60;
			break;
		case "GIN":
			this.type = "Preferred";
			this.last_dividend = 8;
			this.fixed_dividend = 0.02;
			this.par_value = 100;
			break;
		case "JOE":
			this.type = "Common";
			this.last_dividend = 13;
			this.fixed_dividend = 0.0;
			this.par_value = 250;
			break;
		}

	}

	private void calculateDividendYield() {

		if (this.type.equals("Common")) {
			this.dividend_yield = this.last_dividend / this.current_tickerPrice;
		} else {
			this.dividend_yield = (this.fixed_dividend * this.par_value) / this.current_tickerPrice;
		}

	}

	private void calculateRatio() {

		if (this.last_dividend == 0)
			this.ratio = 0.0;
		else {
			this.ratio = this.current_tickerPrice / this.last_dividend;
		}

	}

	public void calculateValues() {
		this.calculateDividendYield();
		this.calculateRatio();
	}

	/*
	 * operation = buy or sell n_shares = quantity of shares
	 * 
	 */
	public void recordTrade(String indicator, int n_shares, double price) {

		ArrayList<String> record = new ArrayList<String>();

		// 1. Timestamp
		java.util.Date date = new java.util.Date();
		Timestamp tstamp = new Timestamp(date.getTime());
		record.add(tstamp.toString());

		// 2. Quantity of shares
		record.add(String.valueOf(n_shares));

		// 3. Buy/Sell indicator
		record.add(indicator);

		// 4. Price
		record.add(String.valueOf(price));

		this.trades.add(record);

	}

	public ArrayList<ArrayList<String>> getTrades() {
		return trades;
	}

	public double getDividend_yield() {
		return dividend_yield;
	}

	public double getRatio() {
		return ratio;
	}

	public String getName() {
		return this.stock;
	}

}
