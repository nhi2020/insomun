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
	

}
