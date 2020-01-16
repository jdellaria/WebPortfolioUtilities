package com.mkyong.stock.bo;

import com.mkyong.stock.model.HistoricalPrices;

public interface HistoricalPricesBo {

	void save(HistoricalPrices stock);

	void update(HistoricalPrices stock);

	void delete(HistoricalPrices stock);

//	HistoricalPrices findByStockCode(HistoricalPrices stockCode);

}
