package com.portfolio.stock.dao;

import com.portfolio.stock.model.Assets;

import java.util.List;

public interface AssetsDao {

	void save(Assets stock);

	void update(Assets stock);

	void delete(Assets stock);

	Assets findByStockId(String stockCode);

 	List<?> findAllAssets();

	List<?> findByType(String stockType);
}
