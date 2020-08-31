package egovframework.let.shop.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.service.SnsProfileVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovSnsUserDAO")
public class EgovSnsUserDAO extends EgovAbstractDAO {

	@SuppressWarnings("unchecked")
	public int insertSnsUser(SnsProfileVO snsProfileVo) throws Exception{
		return (Integer) insert("EgovSnsUserDAO.insertSnsUser", snsProfileVo);
	}

	@SuppressWarnings("unchecked")
	public List<SnsProfileVO> selectSnsUserList(SnsProfileVO snsProfileVo) {
		return (List<SnsProfileVO>) list("EgovSnsUserDAO.selectSnsUserList", snsProfileVo);
	}
	@SuppressWarnings("unchecked")
	public int checkUserLogin(String userid){
		System.out.println("dao.getUserid() : "+userid);
		return (Integer) select ("EgovSnsUserDAO.checkUserLogin", Integer.parseInt(userid));
	}
}
