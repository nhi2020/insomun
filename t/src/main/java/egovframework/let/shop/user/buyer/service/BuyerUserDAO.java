package egovframework.let.shop.user.buyer.service;

import egovframework.let.shop.user.buyer.service.impl.BuyerUserVO;

public interface BuyerUserDAO {

	BuyerUserVO selectUserBuyer(BuyerUserVO vo);

	int updateUserBuyer(BuyerUserVO vo);
	
}
