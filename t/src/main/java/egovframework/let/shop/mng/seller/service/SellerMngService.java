package egovframework.let.shop.mng.seller.service;

import java.util.List;

import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;

public interface SellerMngService {

	int selectSellerMngListCnt(SellerMngVO vo);

	List<SellerMngVO> selectSellerMngList(SellerMngVO vo);

	SellerMngVO sellerSelect(SellerMngVO vo);

	int sellerUpdate(SellerMngVO vo);

}
