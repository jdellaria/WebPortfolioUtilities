package com.portfolio.stock.bo.impl;

import com.portfolio.stock.bo.AssetsBo;
import com.portfolio.stock.dao.AssetsDao;
import com.portfolio.stock.model.Assets;

import java.util.List;

public class AssetsBoImpl implements AssetsBo{

	AssetsDao assetsDao;

	public void setAssetsDao(AssetsDao stockDao) {
		this.assetsDao = stockDao;
	}

	public void save(Assets stock){
		assetsDao.save(stock);
	}

	public void update(Assets stock){
		assetsDao.update(stock);
	}

	public void delete(Assets stock){
		assetsDao.delete(stock);
	}

	public Assets findByStockId(String stockCode){
		return assetsDao.findByStockId(stockCode);
	}

	public List<?> findAllAssets() {
		return assetsDao.findAllAssets();
	}

	public List<?> findByType(String stockType){
		return assetsDao.findByType(stockType);
	}
}
