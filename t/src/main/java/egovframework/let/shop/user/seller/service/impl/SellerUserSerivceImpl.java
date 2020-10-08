package egovframework.let.shop.user.seller.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.admin.service.impl.AdminVO;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.user.seller.service.SellerUserService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("SellerUserService")
public class SellerUserSerivceImpl extends EgovAbstractServiceImpl implements SellerUserService {

    @Resource(name = "SellerUserDAO")
    private SellerUserDAO SellerDAO;

	
	
	public String selectLoginCheck(SellerUserVO sellerVO) throws Exception{
		System.out.println("들감 1");
		System.out.println(sellerVO.getS_id());
		System.out.println(sellerVO.getS_pass());
		
		
		
		return SellerDAO.selectLoginCheck(sellerVO);
	}



	@Override
	public List<SellerUserVO> selectListLoginCheck(SellerUserVO sellervo) throws Exception {
			System.out.println("list impl");
		return (List<SellerUserVO>) SellerDAO.selectLoginCheck2(sellervo);
	}



	@Override
	public String sellerinsertPro(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerinsertPro(vo);
	}


	

	public int selectSellerUserListCnt(SellerMngVO vo) {
		int cnt = SellerDAO.selectSellerUserListCnt(vo);
		return cnt;
	}


	@Override
	public SellerUserVO sellerSearchIdPro(SellerUserVO vo) {
		
		return SellerDAO.sellerSearchIdPro(vo);
	}



	@Override
	public int sellerIdChk(SellerUserVO vo) {
		int result = SellerDAO.sellerIdChk(vo);
		return result;
	}



	@Override
	public int sellerNameEmailChk(SellerUserVO vo) {
		int result = SellerDAO.sellerNameEmailChk(vo);
		return result;
	}



	@Override
	public int sellerAgreeNum(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerAgreeNum(vo);
	}



	@Override
	public int sellerCertificationNumberchk(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return  SellerDAO.sellerCertificationNumberchk(vo);
	}



	@Override
	public String sellerFindId(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerFindId(vo);
	}



	@Override
	public int sellerRePass(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerRePass(vo);
	}



	 @Override
	   public SellerUserVO selectUserSeller(SellerUserVO vo) {
	     return SellerDAO.selectUserSeller(vo);
	   }



	@Override
	public int sellerNicknameChk(SellerUserVO vo) {
		
		return SellerDAO.sellerNicknameChk(vo);
	}



	@Override
	public int sellerEmailChk(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerEmailChk(vo);
	}



	@Override
	public void updateAgreenum(SellerUserVO vo) {
		SellerDAO.updateAgreenum(vo);
		
	}



}
