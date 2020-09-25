package egovframework.let.shop.mng.product.service.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * 게시물 관리를 위한 데이터 접근 클래스
 * @author 공통 서비스 개발팀 이삼섭
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
@Repository("EgovMngProductDAO")
public class ProductMngDAO extends EgovAbstractDAO {

    /**
     * 조건에 맞는 게시물 목록을 조회 한다.
     *
     * @param boardVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<ProductMngVO> selectMngProductList(ProductMngVO productVO) throws Exception {
	return (List<ProductMngVO>) list("EgovMngProductDAO.selectMngProductList", productVO);
    }
    
    public int selectMngProductListCnt(ProductMngVO productVO) throws Exception {
    	return (Integer)select("EgovMngProductDAO.selectMngProductListCnt", productVO);
    }
    
    @SuppressWarnings("unchecked")
	public List<ProductMngVO> updateMngProduct(ProductMngVO productVO) throws Exception {
		return (List<ProductMngVO>) list("EgovMngProductDAO.updateMngProduct", productVO);
    }
}