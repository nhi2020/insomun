package egovframework.let.shop.seller.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.seller.service.EgovSellerService;
import egovframework.let.shop.seller.service.SellerVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovSellerService")
public class EgovSellerServiceImpl extends EgovAbstractServiceImpl implements EgovSellerService {

	@Resource(name = "EgovSellerDAO")
	private EgovSellerDAO sellerDAO;
	
	@Override
	public List<SellerVO> selectSellerList(SellerVO sellerVo) throws Exception {
		List<SellerVO> list = sellerDAO.selectSellerList(sellerVo);
		return list;
	}

}
