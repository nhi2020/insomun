package egovframework.let.shop.mng.seller.service.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SellerMngDAO")
public class SellerMngDAO extends EgovAbstractDAO {


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
    }
}
