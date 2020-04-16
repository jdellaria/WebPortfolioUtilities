package com.portfolio.stock.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.portfolio.stock.dao.HistoricalPricesDao;
import com.portfolio.stock.model.HistoricalPrices;

public class HistoricalPricesDaoImpl extends HibernateDaoSupport implements HistoricalPricesDao{

	public void save(HistoricalPrices stock){
		getHibernateTemplate().save(stock);
	}

	public void update(HistoricalPrices stock){
		getHibernateTemplate().update(stock);
	}

	public void delete(HistoricalPrices stock){
		getHibernateTemplate().delete(stock);
	}

	public HistoricalPrices findByStockCode(String stockCode){
		List list = getHibernateTemplate().find("from Stock where stockCode=?",stockCode);
		return (HistoricalPrices)list.get(0);
	}

}
