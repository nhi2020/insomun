package egovframework.let.shop.mng.deal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.deal.service.DealMng;
import egovframework.let.shop.mng.deal.service.DealMngDAO;
import egovframework.let.shop.mng.deal.service.DealMngService;

@Service("DealMngService")
public class DealMngServiceImpl implements DealMngService {

	@Resource(name = "DealMngDAO")
	private DealMngDAO dealMngDAO;
	
	@Override
	public int selectListCnt(DealMngVO vo) {
		int cnt = dealMngDAO.selectListCnt(vo);
		return cnt;
	}

	@Override
	public List<DealMngVO> selectList(DealMngVO vo) {
		List<DealMngVO> list = dealMngDAO.selectList(vo);
		return list;
	}

	@Override
	public DealMngVO selectMngDealBuyerDetail(DealMngVO vo) {
		System.out.println("DealMngServiceImpl selectMngDealBuyerdetail Start...");
		vo = dealMngDAO.selectMngDealBuyerDetail(vo);
		return vo;
	}

	@Override
	public int updateMngDealBuyerDetail(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateMngDealBuyerDetail Start...");
		int result = dealMngDAO.updateMngDealBuyerDetail(vo);
		return result;
	}

	@Override
	public int updateMngDealBuyerCancel(DealMngVO vo) {
		System.out.println("DealMngServiceImpl updateMngDealBuyerCancel Start...");
		int result = dealMngDAO.updateMngDealBuyerCancel(vo);
		return result;
	}

}
