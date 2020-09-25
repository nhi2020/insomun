package egovframework.let.shop.mng.seller.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.seller.service.SellerMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("SellerMngService")
public class SellerMngSerivceImpl extends EgovAbstractServiceImpl implements SellerMngService {

    @Resource(name = "SellerMngDAO")
    private SellerMngDAO SellerDAO;

	public List<SellerMngVO> selectSellerList(SellerMngVO sellerVO) throws Exception {
		System.out.println("들감 1");
		return null;
	}

	public int selectSellerListCnt(SellerMngVO sellerVO) throws Exception {
		System.out.println("들감 1");
		return 0;
	}

	
	public String selectLoginCheck(SellerMngVO sellerVO) throws Exception{
		System.out.println("들감 1");
		System.out.println(sellerVO.getS_id());
		System.out.println(sellerVO.getS_pass());
		
		return SellerDAO.selectLoginCheck(sellerVO);
	}
	

}
