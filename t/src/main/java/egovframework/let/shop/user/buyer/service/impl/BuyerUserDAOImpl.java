package egovframework.let.shop.user.buyer.service.impl;

import org.springframework.stereotype.Repository;


import egovframework.let.shop.user.buyer.service.BuyerUserDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("BuyerUserDAO")
public class BuyerUserDAOImpl extends EgovAbstractDAO implements BuyerUserDAO{

	@Override
	public BuyerUserVO selectUserBuyer(BuyerUserVO vo) {
		
		try {
			vo = (BuyerUserVO) select("selectUserBuyer", vo);
		} catch (Exception e) {
			System.out.println("BuyerUserDAOImpl selectUserBuyer Exception : " + e.getMessage());
		}
		return vo;
	}

	@Override
	public int updateUserBuyer(BuyerUserVO vo) {
		int result = 0;
		try {
			result = update("updateUserBuyer", vo);
		} catch (Exception e) {
			System.out.println("BuyerUserDAOImpl updateUserBuyer Exception : " + e.getMessage());
		}
		return result;
	}
	

}
