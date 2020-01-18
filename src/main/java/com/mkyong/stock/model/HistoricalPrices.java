package com.mkyong.stock.model;

import java.io.Serializable;
import java.util.Date;

public class HistoricalPrices implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long Id;
	private String symbol;
	private String timeStamp;
	private Date dateStamp;
	private double open;
	private double high;
	private double low;
	private double close;
	private double adjClose;
	private int volume;
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


	public double getOpen() {
		return this.open;
	}

	public void setOpen(double  xPrice) {
		this.open = xPrice;
	}

	public double getHigh() {
		return this.high;
	}

	public void setHigh(double  xPrice) {
		this.high = xPrice;
	}

	public double getLow() {
		return this.low;
	}

	public void setLow(double  xPrice) {
		this.low = xPrice;
	}

	public double getClose() {
		return this.close;
	}

	public void setClose(double  xPrice) {
		this.close = xPrice;
	}

	public double getAdjClose() {
		return this.adjClose;
	}

	public void setAdjClose(double  xPrice) {
		this.adjClose = xPrice;
	}


	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int  xPrice) {
		this.volume = xPrice;
	}
	@Override
	public String toString() {
		return "Stock [stockSymbol=" + symbol + ", Id=" + Id
				+ ", timeStamp=" + timeStamp + "]";
	}


}
