package egovframework.let.shop.user.deal.service;

import java.util.List;

import egovframework.let.shop.user.deal.service.impl.DealUserVO;

public interface DealUserDAO {
	
	int selectListCntDealUser(DealUserVO vo);

	List<DealUserVO> selectListDealUser(DealUserVO vo);
	
	DealUserVO selectDealUserBuyerDetail(DealUserVO vo);

	int updateDealUserBuyerDetail(DealUserVO vo);
	
	int updateDealUserBuyerCancel(DealUserVO vo);

}
