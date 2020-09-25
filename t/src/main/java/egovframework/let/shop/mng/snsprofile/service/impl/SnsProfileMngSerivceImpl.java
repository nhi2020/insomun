package egovframework.let.shop.mng.snsprofile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngSerivce;
import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovSnsUserService")
public class SnsProfileMngSerivceImpl extends EgovAbstractServiceImpl implements SnsProfileMngSerivce {

	@Resource(name = "EgovSnsUserDAO")
	private SnsProfileMngDAO snsUserDAO;

	@Override
	public List<SnsProfileMngVO> selectSnsUserList(SnsProfileMngVO snsProfileVo) throws Exception {
		List<SnsProfileMngVO> list = snsUserDAO.selectSnsUserList(snsProfileVo);
		return list;
	}

	@Override
	public int checkUserLogin(SnsProfileMngVO vo) throws Exception {
		System.out.println("userid : "+vo.getUserid());
		int result = snsUserDAO.checkUserLogin(vo);
		return result;
	}

	@Override
	public String insertSnsUser(SnsProfileMngVO snsProfileVo) throws Exception {
		String result = snsUserDAO.insertSnsUser(snsProfileVo);
		return result;
	}

}
