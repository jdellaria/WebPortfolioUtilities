package com.portfolio.stock.bo.impl;

import com.portfolio.stock.bo.HistoricalPricesBo;
import com.portfolio.stock.dao.HistoricalPricesDao;
import com.portfolio.stock.model.HistoricalPrices;

public class HistoricalPricesBoImpl implements HistoricalPricesBo{

	HistoricalPricesDao historicalPricesDao;

	public void setHistoricalPricesDao(HistoricalPricesDao stockDao) {
		this.historicalPricesDao = stockDao;
	}

	public void save(HistoricalPrices stock){
		historicalPricesDao.save(stock);
	}

	public void update(HistoricalPrices stock){
		historicalPricesDao.update(stock);
	}

	public void delete(HistoricalPrices stock){
		historicalPricesDao.delete(stock);
	}

//	public HistoricalPrices findByStockCode(String stockCode){
//		return HistoricalPricesDao.findByStockCode(stockCode);
//	}
}
