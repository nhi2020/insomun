package egovframework.let.shop.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.user.service.EgovSnsUserService;
import egovframework.let.shop.user.service.SnsProfileVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovSnsUserService")
public class EgovSnsUserServiceImple extends EgovAbstractServiceImpl implements EgovSnsUserService {

	@Resource(name = "EgovSnsUserDAO")
	private EgovSnsUserDAO snsUserDAO;

	@Override
	public List<SnsProfileVO> selectSnsUserList(SnsProfileVO snsProfileVo) throws Exception {
		List<SnsProfileVO> list = snsUserDAO.selectSnsUserList(snsProfileVo);
		return list;
	}

	@Override
	public int checkUserLogin(SnsProfileVO snsProfileVo) throws Exception {
		int result = snsUserDAO.checkUserLogin(snsProfileVo);
		return result;
	}

	@Override
	public int insertSnsUser(SnsProfileVO snsProfileVo) throws Exception {
		int result = snsUserDAO.insertSnsUser(snsProfileVo);
		return result;
	}

}
