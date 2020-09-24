package egovframework.let.shop.buyer.service;

import java.util.List;

import egovframework.let.shop.buyer.dto.BuyerVO;
public interface BuyerService {

	int selectListCnt(BuyerVO vo);

	List<BuyerVO> selectList(BuyerVO vo);

	BuyerVO buyerSelect(BuyerVO vo);

	int buyerUpdate(BuyerVO vo);

}
