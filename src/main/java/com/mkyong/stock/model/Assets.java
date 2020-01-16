package com.mkyong.stock.model;

import java.io.Serializable;
import java.util.Date;

public class Assets implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long stockId;
//	private String stockCode;
	private String name;
	private String type;
	private String symbol;
	private int totalQuantity;
	private double price;
	private double valuation;
	private String incomeFreq;
	private double income;
	private double cost;
	private String costFreq;
	private Date lastUpdated;

	public Assets() {
	}

	public Assets(String stockSymbol, String stockName) {
		this.symbol = stockSymbol;
		this.name = stockName;
	}

	public Long getStockId() {
		return this.stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String stockCode) {
		this.symbol = stockCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String stockName) {
		this.name = stockName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String stockType) {
		this.type = stockType;
	}

	public int getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(int xQuantity) {
		this.totalQuantity = xQuantity;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double xPrice) {
		this.price = xPrice;
	}

	public double getValuation() {
		return this.valuation;
	}

	public void setValuation(double xValuation) {
		this.valuation = xValuation;
	}

	public String getIncomeFreq() {
		return this.incomeFreq;
	}

	public void setIncomeFreq(String xIncomeFreq) {
		this.incomeFreq = xIncomeFreq;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome(double xIncome) {
		this.income = xIncome;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double xCost) {
		this.cost = xCost;
	}

	public String getCostFreq() {
		return this.costFreq;
	}

	public void setCostFreq(String xCostFreq) {
		this.costFreq = xCostFreq;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date xLastUpdated) {
		this.lastUpdated = xLastUpdated;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", stockId=" + stockId
				+ ", stockName=" + name + "]";
	}
}
