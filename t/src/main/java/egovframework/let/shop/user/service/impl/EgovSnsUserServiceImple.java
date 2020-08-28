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

	public int insertSnsUserList(SnsProfileVO snsProfileVo) throws Exception {
		int result = snsUserDAO.insertSnsUserList(snsProfileVo);
		return result;
	}

	public List<SnsProfileVO> selectSnsUserList(SnsProfileVO snsProfileVo) throws Exception {
		List<SnsProfileVO> list = snsUserDAO.selectSnsUserList(snsProfileVo);
		return list;
	}

	@Override
	public List<String> checkUserLogin(SnsProfileVO snsProfileVo) throws Exception {
		List<SnsProfileVO> list = snsUserDAO.checkUserLogin(snsProfileVo);
		return null;
	}

}
