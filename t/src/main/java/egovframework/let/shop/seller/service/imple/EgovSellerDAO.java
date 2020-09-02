package egovframework.let.shop.seller.service.imple;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.seller.service.SellerVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovSellerDAO")
public class EgovSellerDAO extends EgovAbstractDAO{

	@SuppressWarnings("unchecked")
	public List<SellerVO> selectSellerList(SellerVO sellerVo) {
		return (List<SellerVO>) list("EgovSellerDAO.selectSellerList", sellerVo);
		
	}
	
}

