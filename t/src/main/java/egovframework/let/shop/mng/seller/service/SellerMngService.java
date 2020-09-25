package egovframework.let.shop.mng.seller.service;

import java.util.List;

import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;


public interface SellerMngService {

	public List<SellerMngVO> selectSellerList(SellerMngVO sellerVO) throws Exception;

	public int selectSellerListCnt(SellerMngVO sellerVO) throws Exception;
	
	public String selectLoginCheck(SellerMngVO sellerVO) throws Exception;
}