package egovframework.let.shop.buyer.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.service.SnsProfileVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("BuyerDAO")
public class BuyerDAO extends EgovAbstractDAO {

	public int selectBuyerListCnt(SnsProfileVO vo) {
		System.out.println("selectBuyerListCnt => "+(Integer) select("EgovMngProDAO.selectMngProListCnt", vo));
		return (Integer) select("EgovMngProDAO.selectMngProListCnt", vo);
	}

	@SuppressWarnings("unchecked")
	public List<SnsProfileVO> selectBuyerList(SnsProfileVO vo) {
		return (List<SnsProfileVO>) list("EgovMngProDAO.selectMngProList", vo);
	}

}
