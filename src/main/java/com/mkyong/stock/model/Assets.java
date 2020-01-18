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
	private Integer totalQuantity;
	private Double price;
	private Double valuation;
	private String incomeFreq;
	private Double income;
	private Double cost;
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

	public void setTotalQuantity(Integer xQuantity) {
		this.totalQuantity = xQuantity;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double xPrice) {
		this.price = xPrice;
	}

	public Double getValuation() {
		return this.valuation;
	}

	public void setValuation(Double xValuation) {
		this.valuation = xValuation;
	}

	public String getIncomeFreq() {
		return this.incomeFreq;
	}

	public void setIncomeFreq(String xIncomeFreq) {
		this.incomeFreq = xIncomeFreq;
	}

	public Double getIncome() {
		return this.income;
	}

	public void setIncome(Double xIncome) {
		this.income = xIncome;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double xCost) {
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
