package egovframework.let.shop.user.deal.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.deal.service.impl.DealMngVO;
import egovframework.let.shop.user.deal.service.DealUserDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("DealUserDAO")
public class DealUserDAOImpl extends EgovAbstractDAO implements DealUserDAO {

/*	@Autowired
    private SqlSession session;
*/	
	@Override
	public int selectListCntDealUser(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectListCntDealUser Start...");
		int count = 0;
		try {
			count = (int) select("ListCntDealUser", vo);

		} catch (Exception e) {
			System.out.println("ListCntDealUser Exception -> " + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked") // 무점검 경고는, 가능하다면 없애야 한다. 제거할 수 없는 경고 메시지는 형 안정성이 확실할 때만 @SuppressWarnings(“unchecked”) 어노테이션(annotation)을 사용해 억제해야 한다.
	@Override
	public List<DealUserVO> selectListDealUser(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectListDealUser Start...");
		List<DealUserVO> listDealUser = null;
		try {
			listDealUser = (List<DealUserVO>) list("ListDealUser", vo);

		} catch (Exception e) {
			System.out.println("ListDealUser Exception -> " + e.getMessage());
		}
		return listDealUser;
	}

	@Override
	public DealUserVO selectDealUserBuyerDetail(DealUserVO vo) {
		System.out.println("DealUserDAOImpl selectDealUserBuyerDetail Start...");
		try {
			vo = (DealUserVO) select("selectDealUserBuyerDetail", vo);
			
		} catch (Exception e) {
			System.out.println("selectDealUserBuyerDetail Exception -> " + e.getMessage());
		}
		return vo;
	}

	@Override
	public int updateDealUserBuyerDetail(DealUserVO vo) {
		System.out.println("DealUserDAOImpl updateDealUserBuyerDetail Start...");
		int result = 0;
		try {
			result = update("updateDealUserBuyerDetail", vo);
			
		} catch (Exception e) {
			System.out.println("updateDealUserBuyerDetail Exception -> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int updateDealUserBuyerCancel(DealUserVO vo) {
		System.out.println("DealUserDAOImpl updateDealUserBuyerCancel Start...");
		int result = 0;
		try {
			result = update("updateDealUserBuyerCancel", vo);
			
		} catch (Exception e) {
			System.out.println("updateDealUserBuyerCancel Exception -> " + e.getMessage());
		}
		return result;
	}


}
