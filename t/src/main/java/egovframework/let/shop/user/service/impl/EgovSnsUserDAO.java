package egovframework.let.shop.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.service.SnsProfileVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovMngSnsUserDAO")
public class EgovSnsUserDAO extends EgovAbstractDAO {

	@SuppressWarnings("unchecked")
	public int insertSnsUserList(SnsProfileVO snsProfileVo) throws Exception{
		return (Integer) insert("EgovSnsUserDAO.insertSnsUserList", snsProfileVo);
	}

	@SuppressWarnings("unchecked")
	public List<SnsProfileVO> selectSnsUserList(SnsProfileVO snsProfileVo) {
		return (List<SnsProfileVO>) list("EgovSnsUserDAO.selectSnsUserList", snsProfileVo);
	}
	@SuppressWarnings("unchecked")
	public List<SnsProfileVO> checkUserLogin(SnsProfileVO snnProfileVO){
		return (List<SnsProfileVO>) list("EgovSnsUserDAO.checkUserLogin", snnProfileVO);
	}
}
