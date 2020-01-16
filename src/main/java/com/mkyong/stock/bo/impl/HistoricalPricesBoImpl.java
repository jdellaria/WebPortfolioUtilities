package com.mkyong.stock.bo.impl;

import com.mkyong.stock.bo.HistoricalPricesBo;
import com.mkyong.stock.dao.HistoricalPricesDao;
import com.mkyong.stock.model.HistoricalPrices;

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
