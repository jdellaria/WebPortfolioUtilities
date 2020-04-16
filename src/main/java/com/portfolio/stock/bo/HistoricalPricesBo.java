package com.portfolio.stock.bo;

import com.portfolio.stock.model.HistoricalPrices;

public interface HistoricalPricesBo {

	void save(HistoricalPrices stock);

	void update(HistoricalPrices stock);

	void delete(HistoricalPrices stock);

//	HistoricalPrices findByStockCode(HistoricalPrices stockCode);

}
