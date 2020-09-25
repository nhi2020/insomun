package egovframework.let.shop.mng.buyer.service.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.buyer.service.BuyerMngDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("BuyerDAO")
public class BuyerMngDAOImpl extends EgovAbstractDAO implements BuyerMngDAO {

	public int buyerListCnt(BuyerVO vo) {
		System.out.println("BuyerListCnt");
		int count = 0;
		try {
			count = (int) select("BuyerListCnt", vo);

		} catch (Exception e) {
			System.out.println("BuyerListCnt Exception " + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<BuyerVO> buyerList(BuyerVO vo) {
		List<BuyerVO> Buyerlist = null;
		try {
			Buyerlist = (List<BuyerVO>) list("BuyerSelectList", vo);

		} catch (Exception e) {
			System.out.println("BuyerSelectList Exception " + e.getMessage());
		}
		return Buyerlist;
	}

	public BuyerVO buyerSelect(BuyerVO vo) {
		try {
			vo = (BuyerVO) select("BuyerSelect", vo);

		} catch (Exception e) {
			System.out.println("buyerSelect Exception " + e.getMessage());
		}
		return vo;
	}

	public int buyerUpdate(BuyerVO vo) {
		System.out.println("BuyerDAOImpl buyerUpdate");
		System.out.println("vo sns_idx" + vo.getSns_idx());
		int result = 0;
		try {
			result = update("buyerUpdate", vo);

		} catch (Exception e) {
			System.out.println("buyerUpdate Exception " + e.getMessage());
		}
		return result;
	}

}
