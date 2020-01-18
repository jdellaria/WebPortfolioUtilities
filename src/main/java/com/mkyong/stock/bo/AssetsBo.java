package com.mkyong.stock.bo;

import com.mkyong.stock.model.Assets;

public interface AssetsBo {

	void save(Assets stock);

	void update(Assets stock);

	void delete(Assets stock);

	Assets findByStockId(String stockCode);

}
