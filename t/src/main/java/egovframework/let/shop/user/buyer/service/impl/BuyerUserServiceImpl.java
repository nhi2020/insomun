package egovframework.let.shop.user.buyer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.buyer.service.impl.BuyerMngVO;
import egovframework.let.shop.user.buyer.service.BuyerUserDAO;
import egovframework.let.shop.user.buyer.service.BuyerUserService;

@Service("BuyerUserSerivce")
public class BuyerUserServiceImpl implements BuyerUserService{
	
	@Resource(name = "BuyerUserDAO")
	private BuyerUserDAO bd;
	
	@Override
	public BuyerUserVO selectUserBuyer(BuyerUserVO vo) {
		return bd.selectUserBuyer(vo);
	}


}
