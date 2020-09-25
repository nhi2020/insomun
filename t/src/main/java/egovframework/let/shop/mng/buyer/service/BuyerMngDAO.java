package egovframework.let.shop.mng.buyer.service;

import java.util.List;

import egovframework.let.shop.mng.buyer.service.impl.BuyerVO;

public interface BuyerMngDAO {
	
	public int buyerListCnt(BuyerVO vo);
	public List<BuyerVO> buyerList(BuyerVO vo);

}
