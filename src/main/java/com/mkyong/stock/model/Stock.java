package com.mkyong.stock.model;

import java.io.Serializable;

public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long Id;
	private String symbol;
	private String timeStamp;
	private double open;
	private double high;
	private double low;
	private double close;
	private double adjClose;
	public Stock() {
	}

	public Stock(String stockSymbol, String xTimeStamp) {
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
	@Override
	public String toString() {
		return "Stock [stockSymbol=" + symbol + ", Id=" + Id
				+ ", timeStamp=" + timeStamp + "]";
	}


}
