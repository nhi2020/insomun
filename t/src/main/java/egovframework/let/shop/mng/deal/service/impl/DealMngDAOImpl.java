package egovframework.let.shop.mng.deal.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.deal.service.DealMngDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("DealMngDAO")
public class DealMngDAOImpl extends EgovAbstractDAO implements DealMngDAO {

/*	@Autowired
    private SqlSession session;
*/	
	@Override
	public int selectListCnt(DealMngVO vo) {
		System.out.println("DealMngDAOImpl selectListCnt Start...");
		int count = 0;
		try {
			count = (int) select("ListCntDealMng", vo);

		} catch (Exception e) {
			System.out.println("ListCntDealMng Exception " + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked") // 무점검 경고는, 가능하다면 없애야 한다. 제거할 수 없는 경고 메시지는 형 안정성이 확실할 때만 @SuppressWarnings(“unchecked”) 어노테이션(annotation)을 사용해 억제해야 한다.
	@Override
	public List<DealMngVO> selectList(DealMngVO vo) {
		System.out.println("DealMngDAOImpl selectList Start...");
		List<DealMngVO> listDealMng = null;
		try {
			listDealMng = (List<DealMngVO>) list("ListDealMng", vo);

		} catch (Exception e) {
			System.out.println("ListDealMng Exception " + e.getMessage());
		}
		System.out.println("LIST"+listDealMng);
		return listDealMng;
	}

	@Override
	public DealMngVO selectMngDealBuyerDetail(DealMngVO vo) {
		System.out.println("DealMngDAOImpl selectMngDealBuyerDetail Start...");
		try {
			vo = (DealMngVO) select("selectMngDealBuyerDetail", vo);
			
		} catch (Exception e) {
			System.out.println("selectMngDealBuyerDetail Exception ->" + e.getMessage());
		}
		return vo;
	}

	@Override
	public int updateMngDealBuyerDetail(DealMngVO vo) {
		System.out.println("DealMngDAOImpl updateMngDealBuyerDetail Start...");
		int result = 0;
		try {
			result = update("updateMngDealBuyerDetail", vo);
			
		} catch (Exception e) {
			System.out.println("updateMngDealBuyerDetail Exception ->" + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateMngDealBuyerCancel(DealMngVO vo) {
		System.out.println("DealMngDAOImpl updateMngDealBuyerCancel Start...");
		int result = 0;
		try {
			result = update("updateMngDealBuyerCancel", vo);
			
		} catch (Exception e) {
			System.out.println("updateMngDealBuyerCancel Exception ->" + e.getMessage());
		}
		return result;
	}

}
