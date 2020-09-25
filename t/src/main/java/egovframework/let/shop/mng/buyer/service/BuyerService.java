package egovframework.let.shop.mng.buyer.service;

import java.util.List;

import egovframework.let.shop.mng.buyer.service.impl.BuyerVO;
public interface BuyerService {

	int selectListCnt(BuyerVO vo);

	List<BuyerVO> selectList(BuyerVO vo);

	BuyerVO buyerSelect(BuyerVO vo);

	int buyerUpdate(BuyerVO vo);

}
