package egovframework.let.shop.buyer.service;

import java.util.List;

public interface BuyerService {

	int selectListCnt(BuyerVO vo);

	List<BuyerVO> selectList(BuyerVO vo);

}
