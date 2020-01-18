package com.mkyong.stock.dao;

import com.mkyong.stock.model.Assets;

public interface AssetsDao {

	void save(Assets stock);

	void update(Assets stock);

	void delete(Assets stock);

	Assets findByStockId(String stockCode);

}
