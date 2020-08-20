package egovframework.let.shop.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.shop.user.service.SnsProfileVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("EgovMngSnsUserDAO")
public class EgovSnsUserDAO extends EgovAbstractDAO {

	@SuppressWarnings("unchecked")
	public List<SnsProfileVO> insertSnsUserList(SnsProfileVO snsProfileVo) throws Exception{
		return (List<SnsProfileVO>) list("EgovSnsUserDAO.insertSnsUserList", snsProfileVo);
	}
}
