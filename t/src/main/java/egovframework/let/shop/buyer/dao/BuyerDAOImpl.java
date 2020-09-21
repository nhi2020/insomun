package egovframework.let.shop.buyer.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.let.shop.buyer.dto.BuyerVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("BuyerDAO")
public class BuyerDAOImpl extends EgovAbstractDAO implements BuyerDAO {


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

}
