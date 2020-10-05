package egovframework.let.shop.user.deal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.deal.service.DealUserDAO;
import egovframework.let.shop.user.deal.service.DealUserService;

@Service("DealUserService")
public class DealUserServiceImpl implements DealUserService {

	@Resource(name = "DealUserDAO")
	private DealUserDAO dealUserDAO;
	
	@Override
	public int selectListCntDealUser(DealUserVO vo) {
		int cnt = dealUserDAO.selectListCntDealUser(vo);
		return cnt;
	}

	@Override
	public List<DealUserVO> selectListDealUser(DealUserVO vo) {
		List<DealUserVO> list = dealUserDAO.selectListDealUser(vo);
		return list;
	}

	@Override
	public DealUserVO selectDealUserBuyerDetail(DealUserVO vo) {
		System.out.println("DealUserServiceImpl selectDealUserBuyerDetail Start...");
		vo = dealUserDAO.selectDealUserBuyerDetail(vo);
		return vo;
	}

	@Override
	public int updateDealUserBuyerDetail(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserBuyerDetail Start...");
		int result = dealUserDAO.updateDealUserBuyerDetail(vo);
		return result;
	}

	@Override
	public int updateDealUserBuyerCancel(DealUserVO vo) {
		System.out.println("DealUserServiceImpl updateDealUserBuyerCancel Start...");
		int result = dealUserDAO.updateDealUserBuyerCancel(vo);
		return result;
	}

}
