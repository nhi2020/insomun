package egovframework.let.shop.seller.service;

import java.util.List;

public interface EgovSellerService {
	
	public List<SellerVO> selectSellerList(SellerVO sellerVo) throws Exception;
}
