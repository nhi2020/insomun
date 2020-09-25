package egovframework.let.shop.mng.snsprofile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.shop.mng.snsprofile.service.SnsProfileMngSerivce;
import egovframework.let.shop.mng.snsprofile.service.SnsProfileVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("EgovSnsUserService")
public class SnsProfileMngSerivceImpl extends EgovAbstractServiceImpl implements SnsProfileMngSerivce {

	@Resource(name = "EgovSnsUserDAO")
	private SnsProfileMngDAO snsUserDAO;

	@Override
	public List<SnsProfileVO> selectSnsUserList(SnsProfileVO snsProfileVo) throws Exception {
		List<SnsProfileVO> list = snsUserDAO.selectSnsUserList(snsProfileVo);
		return list;
	}

	@Override
	public int checkUserLogin(SnsProfileVO vo) throws Exception {
		System.out.println("userid : "+vo.getUserid());
		int result = snsUserDAO.checkUserLogin(vo);
		return result;
	}

	@Override
	public String insertSnsUser(SnsProfileVO snsProfileVo) throws Exception {
		String result = snsUserDAO.insertSnsUser(snsProfileVo);
		return result;
	}

}
