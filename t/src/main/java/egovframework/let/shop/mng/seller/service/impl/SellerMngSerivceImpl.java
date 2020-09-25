package egovframework.let.shop.mng.seller.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.seller.service.SellerMngService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * 게시물 관리를 위한 서비스 구현 클래스
 * @author 공통 서비스 개발팀 한성곤
 * @since 2009.03.19
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.19  이삼섭          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *  
 *  </pre>
 */
@Service("EgovSellerService")
public class SellerMngSerivceImpl extends EgovAbstractServiceImpl implements SellerMngService {

    @Resource(name = "EgovSellerDAO")
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
