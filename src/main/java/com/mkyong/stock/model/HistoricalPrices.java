package com.mkyong.stock.model;

import java.io.Serializable;
import java.util.Date;

public class HistoricalPrices implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long Id;
	private String symbol;
	private String timeStamp;
	private Date dateStamp;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private Double adjClose;
	private Integer volume;
	public HistoricalPrices() {
	}

	public HistoricalPrices(String stockSymbol, String xTimeStamp) {
		this.symbol = stockSymbol;
		this.timeStamp = xTimeStamp;
	}

	public Long getId() {
		return this.Id;
	}

	public void setId(Long stockId) {
		this.Id = stockId;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String stockSymbol) {
		this.symbol = stockSymbol;
	}

	public String getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(String xTimeStamp) {
		this.timeStamp = xTimeStamp;
	}

	public Date getDateStamp() {
		return this.dateStamp;
	}

	public void setDateStamp(Date xTimeStamp) {
		this.dateStamp = xTimeStamp;
	}


	public Double getOpen() {
		return this.open;
	}

	public void setOpen(Double  xPrice) {
		this.open = xPrice;
	}

	public void setOpen(String  xPrice) {
		this.open = stringToDouble(xPrice);;
	}

	public Double getHigh() {
		return this.high;
	}

	public void setHigh(Double  xPrice) {
		this.high = xPrice;
	}

	public void setHigh(String  xPrice) {
		this.high = stringToDouble(xPrice);;
	}

	public Double getLow() {
		return this.low;
	}

	public void setLow(Double  xPrice) {
		this.low = xPrice;
	}

	public void setLow(String  xPrice) {
		this.low = stringToDouble(xPrice);;
	}

	public Double getClose() {
		return this.close;
	}

	public void setClose(Double  xPrice) {
		this.close = xPrice;
	}

	public void setClose(String  xPrice) {
		this.close = stringToDouble(xPrice);;
	}

	public Double getAdjClose() {
		return this.adjClose;
	}

	public void setAdjClose(Double  xPrice) {
		this.adjClose = xPrice;
	}

	public void setAdjClose(String  xPrice) {
		this.adjClose = stringToDouble(xPrice);;
	}

	public Integer getVolume() {
		return this.volume;
	}

	public void setVolume(Integer  xPrice) {
		this.volume = xPrice;
	}

	public void setVolume(String  xPrice) {
		this.volume = stringToInteger(xPrice);
	}


	public static Double stringToDouble(String  sPrice) {
		String conversionString = sPrice.replaceAll("[^0-9.]", "");
//		conversionString = conversionString.replaceAll("-", "");
//			System.out.println("conversionString : " + conversionString);
		if (conversionString.length() > 0)
		{
			return Double.parseDouble(conversionString);
		}
		return null;
	}

	public static Integer stringToInteger(String  sPrice) {
		String conversionString = sPrice.replaceAll("[^0-9]", "");
	//			System.out.println("conversionString : " + conversionString);
		if (conversionString.length() > 0)
		{
			return Integer.parseInt(conversionString);
		}
		return null;
	}

	@Override
	public String toString() {
		return "Stock [stockSymbol=" + symbol + ", Id=" + Id
				+ ", timeStamp=" + timeStamp + "]";
	}


}
