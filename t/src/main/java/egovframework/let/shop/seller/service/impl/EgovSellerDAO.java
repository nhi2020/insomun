package egovframework.let.shop.seller.service.impl;
import java.util.List;

import org.springframework.stereotype.Repository;


import egovframework.let.shop.seller.service.SellerVO;
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
@Repository("EgovSellerDAO")
public class EgovSellerDAO extends EgovAbstractDAO {

    /**
     * 조건에 맞는 게시물 목록을 조회 한다.
     *
     * @param boardVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<SellerVO> selectSellerList(SellerVO sellerVO) throws Exception {
    	System.out.println("들감1");
	return (List<SellerVO>) list("EgovSellerDAO.selectSellerList1", sellerVO);
    }								

    public int selectSellerListCnt(SellerVO sellerVO) throws Exception {
    	System.out.println("들감2");
    	return (Integer)select("EgovSellerDAO.selectSellerListCnt1", sellerVO);
    }
    
    public String selectLoginCheck(SellerVO sellerVO) throws Exception {
    	System.out.println("들감2");
    	System.out.println(sellerVO);
    	return (String) select("EgovSellerDAO.selectLoginCheck1",sellerVO);
    }
}
