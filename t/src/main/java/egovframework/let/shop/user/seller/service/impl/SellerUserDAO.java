package egovframework.let.shop.user.seller.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.admin.service.impl.AdminVO;
import egovframework.let.shop.mng.seller.service.impl.SellerMngVO;
import egovframework.let.shop.user.seller.service.impl.SellerUserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SellerUserDAO")
public class SellerUserDAO extends EgovAbstractDAO {


	public String selectLoginCheck(SellerUserVO sellerVO) throws Exception{
		System.out.println("들감2");
    	System.out.println(sellerVO);
    	return (String) select("EgovSellerDAO.selectLoginCheck1",sellerVO);
	}

	@SuppressWarnings("unchecked")
	public List<SellerUserVO> selectLoginCheck2(SellerUserVO sellervo) {
		System.out.println("list dao");
		return (List<SellerUserVO>) list("EgovSellerDAO.selectLoginListCheck",sellervo);
	}


	public String sellerinsertPro(SellerUserVO vo) {
		 
		return (String) insert("EgovSellerDAO.sellerinsertPro",vo);
	}



	
	public int selectSellerUserListCnt(SellerMngVO vo) {
		System.out.println("selectSellerUserListCnt");
		int count = 0;
		try {
			count = (int) select("selectSellerUserListCnt", vo);
		} catch (Exception e) {
			System.out.println("selectSellerUserListCnt" + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<SellerMngVO> selectSellerUserList(SellerMngVO vo) {
		List<SellerMngVO> SelectSellerUserList = null;
		try {
			SelectSellerUserList = (List<SellerMngVO>) list("SelectSellerUserList", vo);
		} catch (Exception e) {
			System.out.println("SelectSellerUserList Exception" + e.getMessage());
		}
		return SelectSellerUserList;
	}

	public SellerUserVO sellerSearchIdPro(SellerUserVO vo) {
		
		return (SellerUserVO) select("EgovSellerDAO.sellerSearchIdPro",vo);
	}

	public int sellerIdChk(SellerUserVO vo) {
		int result = (int) select("EgovSellerDAO.sellerIdChk",vo);
		return result;
	}

	public int sellerNameEmailChk(SellerUserVO vo) {
		int result = (int) select("EgovSellerDAO.sellerNameEmailChk",vo);
		return result;
	}

	public int sellerAgreeNum(SellerUserVO vo) {
		
		return update("EgovSellerDAO.sellerAgreeNum",vo);
	}

	public int sellerCertificationNumberchk(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return (int) select("EgovSellerDAO.sellerCertificationNumberchk",vo);
	}

	public String sellerFindId(SellerUserVO vo) {
		String result = (String) select("EgovSellerDAO.sellerFindId",vo);
		return result;
	}

	public int sellerRePass(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return (int) update("EgovSellerDAO.sellerRePass",vo);
	}

	 public SellerUserVO selectUserSeller(SellerUserVO vo) {
	      try {
	         vo = (SellerUserVO) select("selectUserSeller", vo);
	      } catch (Exception e) {
	         System.out.println("SellerUserDAO selectUserSeller Exception : " + e.getMessage());
	      }
	      return vo;
	   }

	public int sellerNicknameChk(SellerUserVO vo) {
		
		
		
		return (int) select("EgovSellerDAO.sellerNicknameChk",vo);
	}

	public int sellerEmailChk(SellerUserVO vo) {
		// TODO Auto-generated method stub
		return (int) select("EgovSellerDAO.sellerEmailChk",vo);
	}



}
