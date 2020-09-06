package egovframework.let.shop.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.product.service.EgovMngProductService;
import egovframework.let.shop.product.service.ProductVO;
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
@Service("EgovMngProductService")
public class EgovMngProductServiceImpl extends EgovAbstractServiceImpl implements EgovMngProductService {

    @Resource(name = "EgovMngProductDAO")
    private EgovMngProductDAO mngProductDAO;

	/**
     * 조건에 맞는 게시물 목록을 조회 한다.
     * 
     * @see egovframework.let.cop.bbs.brd.service.EgovBBSManageService#selectBoardArticles(egovframework.let.cop.bbs.brd.service.BoardVO)
     */
    public List<ProductVO> selectMngProductList(ProductVO productVO) throws Exception {
    	List<ProductVO> list = mngProductDAO.selectMngProductList(productVO);
    	return list;
    }

	@Override
	public int selectMngProductListCnt(ProductVO productVO) throws Exception {
		int cnt = mngProductDAO.selectMngProductListCnt(productVO);
		return cnt;
	}

	@Override
	public List<ProductVO> updateMngProduct(ProductVO productVO) throws Exception {
		List<ProductVO> list = mngProductDAO.updateMngProduct(productVO);
		return list;
	}

}
