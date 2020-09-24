package egovframework.let.shop.buyer.dao;

import java.util.List;

import egovframework.let.shop.buyer.dto.BuyerVO;

public interface BuyerDAO {
	
	public int buyerListCnt(BuyerVO vo);
	public List<BuyerVO> buyerList(BuyerVO vo);

}
