package com.mkyong.stock.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mkyong.stock.dao.AssetsDao;
import com.mkyong.stock.model.Assets;

public class AssetsDaoImpl extends HibernateDaoSupport implements AssetsDao{

	public void save(Assets stock){
		getHibernateTemplate().save(stock);
	}

	public void update(Assets stock){
		getHibernateTemplate().update(stock);
	}

	public void delete(Assets stock){
		getHibernateTemplate().delete(stock);
	}

	public Assets findByStockCode(String stockCode){
		List list = getHibernateTemplate().find("from Assets where stockCode=?",stockCode);
		return (Assets)list.get(0);
	}

}
