package egovframework.let.shop.buyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.buyer.service.BuyerService;
import egovframework.let.shop.user.service.SnsProfileVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("BuyerService")
public class BuyerServiceImpl extends EgovAbstractServiceImpl implements BuyerService {

	@Resource(name = "BuyerDAO")
	private BuyerDAO BuyerDAO;

	@Override
	public int selectListCnt(SnsProfileVO vo) {
		int cnt = BuyerDAO.selectBuyerListCnt(vo);
		return cnt;
	}

	@Override
	public List<SnsProfileVO> selectList(SnsProfileVO vo) {
		List<SnsProfileVO> list = BuyerDAO.selectBuyerList(vo);
		return list;
	}

}
