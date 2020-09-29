package egovframework.let.shop.user.seller.service;

import java.util.List;

import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.user.seller.service.impl.SellerUserVO;

public interface SellerUserService {

	/*
	public List<SellerMngVO> selectSellerList(SellerMngVO sellerVO) throws Exception;

	public int selectSellerListCnt(SellerMngVO sellerVO) throws Exception;
	
	public String selectLoginCheck(SellerMngVO sellerVO) throws Exception;*/

	public String selectLoginCheck(SellerUserVO sellervo)throws Exception;

	public List<SellerUserVO> selectListLoginCheck(SellerUserVO sellervo)throws Exception;

	public int selectSellerUserListCnt(SellerMngVO vo);

	public List<SellerMngVO> selectSellerUserList(SellerMngVO vo);
}