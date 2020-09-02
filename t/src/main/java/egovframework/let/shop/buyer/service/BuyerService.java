package egovframework.let.shop.buyer.service;

import java.util.List;

import egovframework.let.shop.user.service.SnsProfileVO;

public interface BuyerService {

	int selectListCnt(SnsProfileVO vo);

	List<SnsProfileVO> selectList(SnsProfileVO vo);

}
