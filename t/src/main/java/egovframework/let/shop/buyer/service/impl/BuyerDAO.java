package egovframework.let.shop.buyer.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.buyer.service.BuyerVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("BuyerDAO")
public class BuyerDAO extends EgovAbstractDAO {

	public int selectBuyerListCnt(BuyerVO vo) {
		return (Integer) select("BuyerDAO.selectBuyerListCnt", vo);
	}

	@SuppressWarnings("unchecked")
	public List<BuyerVO> selectBuyerList(BuyerVO vo) {
		return (List<BuyerVO>) list("BuyerDAO.selectBuyerList", vo);
	}

}
