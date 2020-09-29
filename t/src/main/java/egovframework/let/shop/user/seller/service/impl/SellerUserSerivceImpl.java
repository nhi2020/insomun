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
<<<<<<< HEAD
	public SellerUserVO sellerinsertPro(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return SellerDAO.sellerinsertPro(vo);
	}



	@Override
	public int sellerSearchIdPro(SellerUserVO vo) throws Exception {
		// TODO Auto-generated method stub
		return SellerDAO.sellerSearchIdPro(vo);
	}



	
=======
	public int selectSellerUserListCnt(SellerMngVO vo) {
		int cnt = SellerDAO.selectSellerUserListCnt(vo);
		return cnt;
	}



	@Override
	public List<SellerMngVO> selectSellerUserList(SellerMngVO vo) {
		List<SellerMngVO> list = SellerDAO.selectSellerUserList(vo);
		return list;
	}
>>>>>>> branch 'master' of https://github.com/nhi2020/insomun.git
	

}
