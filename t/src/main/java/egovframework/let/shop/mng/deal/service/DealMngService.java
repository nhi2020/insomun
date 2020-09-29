package egovframework.let.shop.mng.deal.service;

import java.util.List;

import egovframework.let.shop.mng.deal.service.impl.DealMngVO;

public interface DealMngService {

	int selectListCnt(DealMngVO vo);

	List<DealMngVO> selectList(DealMngVO vo);
	
	DealMngVO selectMngDealBuyerDetail(DealMngVO vo);

	int updateMngDealBuyerDetail(DealMngVO vo);
	
}
