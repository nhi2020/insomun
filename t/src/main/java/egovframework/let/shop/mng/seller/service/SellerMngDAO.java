package egovframework.let.shop.mng.seller.service;

import java.util.List;

import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;

public interface SellerMngDAO {

	public int selectSellerMngListCnt(SellerMngVO vo);
	public List<SellerMngVO> selectSellerMngList(SellerMngVO vo);


}
