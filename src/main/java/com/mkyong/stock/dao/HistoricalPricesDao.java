package com.mkyong.stock.dao;

import com.mkyong.stock.model.HistoricalPrices;

public interface HistoricalPricesDao {

	void save(HistoricalPrices stock);

	void update(HistoricalPrices stock);

	void delete(HistoricalPrices stock);

	HistoricalPrices findByStockCode(String stockCode);

}
