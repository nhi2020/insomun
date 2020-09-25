package egovframework.let.shop.mng.snsprofile.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovSnsUserDAO")
public class SnsProfileMngDAO extends EgovAbstractDAO {

	@SuppressWarnings("unchecked")
	public String insertSnsUser(SnsProfileMngVO snsProfileVo) throws Exception{
		return (String)insert("EgovSnsUserDAO.insertSnsUser", snsProfileVo);
	}

	@SuppressWarnings("unchecked")
	public List<SnsProfileMngVO> selectSnsUserList(SnsProfileMngVO snsProfileVo) {
		return (List<SnsProfileMngVO>) list("EgovSnsUserDAO.selectSnsUserList", snsProfileVo);
	}
	@SuppressWarnings("unchecked")
	public int checkUserLogin(SnsProfileMngVO vo){
		System.out.println("dao.getUserid() : "+vo.getUserid());
		int result=(Integer)select("EgovSnsUserDAO.checkUserLogin", vo);
		return result;
	}
}
