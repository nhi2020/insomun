package egovframework.let.shop.buyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.buyer.service.BuyerService;
import egovframework.let.shop.buyer.service.BuyerVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("BuyerService")
public class BuyerServiceImpl extends EgovAbstractServiceImpl implements BuyerService {

	@Resource(name = "BuyerDAO")
	private BuyerDAO BuyerDAO;

	@Override
	public int selectListCnt(BuyerVO vo) {
		int cnt = BuyerDAO.selectBuyerListCnt(vo);
		return cnt;
	}

	@Override
	public List<BuyerVO> selectList(BuyerVO vo) {
		List<BuyerVO> list = BuyerDAO.selectBuyerList(vo);
		return list;
	}

}
