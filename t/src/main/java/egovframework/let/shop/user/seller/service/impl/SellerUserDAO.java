package egovframework.let.shop.user.seller.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.admin.service.impl.AdminVO;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.user.seller.service.impl.SellerUserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SellerUserDAO")
public class SellerUserDAO extends EgovAbstractDAO {

/*
    @SuppressWarnings("unchecked")
    public List<SellerMngVO> selectSellerList(SellerMngVO sellerVO) throws Exception {
    	System.out.println("들감1");
	return (List<SellerMngVO>) list("EgovSellerDAO.selectSellerList1", sellerVO);
    }								

    public int selectSellerListCnt(SellerMngVO sellerVO) throws Exception {
    	System.out.println("들감2");
    	return (Integer)select("EgovSellerDAO.selectSellerListCnt1", sellerVO);
    }
    
    public String selectLoginCheck(SellerMngVO sellerVO) throws Exception {
    	System.out.println("들감2");
    	System.out.println(sellerVO);
    	return (String) select("EgovSellerDAO.selectLoginCheck1",sellerVO);
    }*/

	public String selectLoginCheck(SellerUserVO sellerVO) throws Exception{
		System.out.println("들감2");
    	System.out.println(sellerVO);
    	return (String) select("EgovSellerDAO.selectLoginCheck1",sellerVO);
	}

	@SuppressWarnings("unchecked")
	public List<SellerUserVO> selectLoginCheck2(SellerUserVO sellervo) {
		System.out.println("list dao");
		return (List<SellerUserVO>) list("EgovSellerDAO.selectLoginListCheck",sellervo);
	}
	
	public int selectSellerUserListCnt(SellerMngVO vo) {
		System.out.println("selectSellerUserListCnt");
		int count = 0;
		try {
			count = (int) select("selectSellerUserListCnt", vo);
		} catch (Exception e) {
			System.out.println("selectSellerUserListCnt" + e.getMessage());
		}
		return count;
	}

	public List<SellerMngVO> selectSellerUserList(SellerMngVO vo) {
		List<SellerMngVO> SelectSellerUserList = null;
		try {
			SelectSellerUserList = (List<SellerMngVO>) list("SelectSellerUserList", vo);
		} catch (Exception e) {
			System.out.println("SelectSellerUserList Exception" + e.getMessage());
		}
		return SelectSellerUserList;
	}
}
