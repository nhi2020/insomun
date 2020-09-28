package egovframework.let.shop.user.seller.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import egovframework.let.shop.user.seller.service.SellerUserService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("SellerUserService")
public class SellerUserSerivceImpl extends EgovAbstractServiceImpl implements SellerUserService {

    @Resource(name = "SellerUserDAO")
    private SellerUserDAO SellerDAO;

	
	
	public String selectLoginCheck(SellerUserVO sellerVO) throws Exception{
		System.out.println("들감 1");
		System.out.println(sellerVO.getS_id());
		System.out.println(sellerVO.getS_pass());
		
		return SellerDAO.selectLoginCheck(sellerVO);
	}
	

}
