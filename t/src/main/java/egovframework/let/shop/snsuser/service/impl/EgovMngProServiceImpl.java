package egovframework.let.shop.snsuser.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.snsuser.service.EgovMngProService;
import egovframework.let.shop.snsuser.service.ProVO;
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
@Service("EgovMngProService")
public class EgovMngProServiceImpl extends EgovAbstractServiceImpl implements EgovMngProService {

    @Resource(name = "EgovMngProDAO")
    private EgovMngProDAO mngProDAO;

	/**
     * 조건에 맞는 게시물 목록을 조회 한다.
     * 
     * @see egovframework.let.cop.bbs.brd.service.EgovBBSManageService#selectBoardArticles(egovframework.let.cop.bbs.brd.service.BoardVO)
     */
    public List<ProVO> selectMngProList(ProVO proVO) throws Exception {
    	List<ProVO> list = mngProDAO.selectMngProList(proVO);
    	return list;
    }

	@Override
	public int selectMngProListCnt(ProVO proVO) throws Exception {
		int cnt = mngProDAO.selectMngProListCnt(proVO);
		return cnt;
	}

}
