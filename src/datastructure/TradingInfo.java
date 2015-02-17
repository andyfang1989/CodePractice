package datastructure;
import java.util.Date;

public class TradingInfo implements Comparable<TradingInfo> {
	private Date tradingTime;
	private double tradingPrice;
	
	public TradingInfo(Date tradingTime, double tradingPrice) {
		this.tradingTime = tradingTime;
		this.tradingPrice = tradingPrice;
	}
	
	public Date getTradingTime() {
		return tradingTime;
	}

	public void setTradingTime(Date tradingTime) {
		this.tradingTime = tradingTime;
	}

	public double getTradingPrice() {
		return tradingPrice;
	}

	public void setTradingPrice(double tradingPrice) {
		this.tradingPrice = tradingPrice;
	}

	@Override
	public int compareTo(TradingInfo o) {
		// TODO Auto-generated method stub
		if (this.getTradingTime().compareTo(o.getTradingTime()) < 0)
			return -1;
		else if (this.getTradingTime().compareTo(o.getTradingTime()) > 0)
			return 1;
		else
			return 0;
	}
}
