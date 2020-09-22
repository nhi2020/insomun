package egovframework.let.shop.buyer.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.buyer.dao.BuyerDAOImpl;
import egovframework.let.shop.buyer.dto.BuyerVO;
import egovframework.let.shop.buyer.service.BuyerService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("BuyerService")
public class BuyerServiceImpl extends EgovAbstractServiceImpl implements BuyerService {

	@Resource(name = "BuyerDAO")
	private BuyerDAOImpl BuyerDAO;

	@Override
	public int selectListCnt(BuyerVO vo) {
		int cnt = BuyerDAO.buyerListCnt(vo);
		return cnt;
	}

	@Override
	public List<BuyerVO> selectList(BuyerVO vo) {
		List<BuyerVO> list = BuyerDAO.buyerList(vo);
		return list;
	}

	@Override
	public BuyerVO buyerSelect(BuyerVO vo) {
		vo = BuyerDAO.buyerSelect(vo);
		return vo;
	}

	@Override
	public int buyerUpdate(BuyerVO vo) {
		int result = BuyerDAO.buyerUpdate(vo);
		return result;
	}

}
